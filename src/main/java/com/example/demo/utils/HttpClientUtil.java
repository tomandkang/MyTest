package com.example.demo.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {


    /**
     * 设置超时时间
     */
    private static RequestConfig getRequestConfig() {
        return RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
    }


    public static void close(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) {
        // 关闭资源
        if (null != httpResponse) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != httpClient) {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(CloseableHttpResponse httpResponse, String filePath) throws Exception {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = httpResponse.getEntity().getContent();
            Header[] responseHeaders = httpResponse.getHeaders("Content-Disposition");
            if (responseHeaders != null && responseHeaders.length > 0) {
                String header = responseHeaders[0].toString();
                if (header.contains("filename")) {
                    int length = header.length();
                    String fileName = header.substring(header.indexOf("filename="), length);
                    String[] str = fileName.split("=");
                    filePath = filePath + str[1];
                    FileUtils.createFile(filePath);
                    File reportFile = new File(filePath);
                    outputStream = new FileOutputStream(reportFile);
                    FileCopyUtils.copy(inputStream, outputStream);
                }
            }
        } catch (IOException e) {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }


    public static String doGet(String url, Map<String, Object> headers) throws Exception {
        String result = "";
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            // 设置请求头
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            throw e;
        } finally {
            close(httpResponse, httpClient);
        }
        return result;
    }

    public static String downloadFile(String url, Map<String, Object> headers, String dir) throws Exception {
        CloseableHttpResponse httpResponse = null;
        String localPath = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            httpGet.setProtocolVersion(HttpVersion.HTTP_1_0);
            // 设置请求头
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine() != null && httpResponse.getStatusLine().getStatusCode() == 200) {
                copyFile(httpResponse, dir);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(httpResponse, httpClient);
        }
        return localPath;
    }

    public static String doPostJson(String url, Map<String, Object> headers, String jsonString) throws Exception {
        String result = "";
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            // 设置请求头
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(jsonString, "utf-8");
            requestEntity.setContentType("application/json");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(requestEntity);
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            close(httpResponse, httpClient);
        }
    }


    public static String doPostFrom(String url, Map<String, Object> headers, Map<String, String> paramMap) throws Exception {
        String result = "";
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            // 设置请求头
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            //装填参数
            List<NameValuePair> nvps = new ArrayList<>();
            if (!CollectionUtils.isEmpty(paramMap)) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps, "utf-8");
            urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
            urlEncodedFormEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            close(httpResponse, httpClient);
        }
    }


    public static String doPutXml(String url, Map<String, Object> headers, String xmlData) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = getRequestConfig();
        httpPut.setConfig(requestConfig);
        // 设置请求头
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPut.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        InputStreamEntity reqEntity = new InputStreamEntity(new ByteArrayInputStream(xmlData.getBytes()));
        reqEntity.setContentType("application/xml");
        reqEntity.setContentEncoding("utf-8");
        reqEntity.setChunked(true);
        httpPut.setEntity(reqEntity);
        try {
            httpResponse = httpClient.execute(httpPut);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            close(httpResponse, httpClient);
        }
    }


    public static String uploadFile(Map<String, Object> headers, String url, File file) throws Exception {
        String result = "";
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            //HttpMultipartMode.RFC6532参数的设定是为避免文件名为中文时乱码
            MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
            builder.addBinaryBody("file", file);
            HttpEntity httpEntity = builder.build();
            httpPost.setEntity(httpEntity);
            httpResponse = httpClient.execute(httpPost);// 执行提交
            HttpEntity entity = httpResponse.getEntity();//接收调用外部接口返回的内容
            result = EntityUtils.toString(entity);
            return result;
        } catch (Exception e) {
            throw e;
        } finally {//处理结束后关闭httpclient的链接
            close(httpResponse, httpClient);
        }
    }


    public static String doDel(String url, Map<String, Object> headers) throws Exception {
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = getRequestConfig();
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setConfig(requestConfig);
        try {
            // 设置请求头
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                httpDelete.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
            httpResponse = httpClient.execute(httpDelete);
            HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity);
        } finally {
            close(httpResponse, httpClient);
        }
    }


}
