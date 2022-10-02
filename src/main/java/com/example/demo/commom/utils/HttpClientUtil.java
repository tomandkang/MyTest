package com.example.demo.commom.utils;

import com.alibaba.fastjson.JSONObject;

import com.example.demo.commom.myHandler.model.UploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.util.TimeValue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/15 18:25
 * @description http 连接客户端
 */
@Slf4j
public class HttpClientUtil {

    private static String FILE_UPLOAD_GETAWAY = "http://www.soter.youkeshu.com/yks/file/server/";

    private static String  FILE_DIRECTORY = "/opt/tmp/";

    private HttpClientUtil() {
    }

    /**
     * HttpClient 对象
     */
    private static CloseableHttpClient httpClient = null;
    /**
     * CookieStore 对象
     */
    private static CookieStore cookieStore = null;
    /**
     * Basic Auth 管理对象
     **/
    private static BasicCredentialsProvider basicCredentialsProvider = null;

    // Httpclient 初始化
    static {
        // 注册访问协议相关的 Socket 工厂
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
        // Http 连接池
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        poolingHttpClientConnectionManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(30, TimeUnit.SECONDS).setTcpNoDelay(true).build());
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(200);
        poolingHttpClientConnectionManager.setValidateAfterInactivity(TimeValue.ofMinutes(5));
        // Http 请求配置
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000, TimeUnit.MILLISECONDS).setResponseTimeout(5000, TimeUnit.MILLISECONDS).setConnectionRequestTimeout(5000, TimeUnit.MILLISECONDS).build();
        // 设置 Cookie
        cookieStore = new BasicCookieStore();
        // 设置 Basic Auth 对象
        basicCredentialsProvider = new BasicCredentialsProvider();
        // 创建监听器，在 JVM 停止或重启时，关闭连接池释放掉连接
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                log.info("执行关闭 HttpClient");
                httpClient.close();
                log.info("已经关闭 HttpClient");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }));
        // 创建 HttpClient 对象
        httpClient = HttpClients.custom()
                // 设置 Cookie
                .setDefaultCookieStore(cookieStore)
                // 设置 Basic Auth
                .setDefaultCredentialsProvider(basicCredentialsProvider)
                // 设置 HttpClient 请求参数
                .setDefaultRequestConfig(requestConfig)
                // 设置连接池
                .setConnectionManager(poolingHttpClientConnectionManager)
                // 设置定时清理连接池中过期的连接
                .evictExpiredConnections().evictIdleConnections(TimeValue.ofMinutes(3)).build();
    }

    /**
     * 获取 Httpclient 对象
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient getHttpclient() {
        return httpClient;
    }

    /**
     * 获取 CookieStore 对象
     *
     * @return CookieStore
     */
    public static CookieStore getCookieStore() {
        return cookieStore;
    }

    /**
     * 获取 BasicCredentialsProvider 对象
     *
     * @return BasicCredentialsProvider
     */
    public static BasicCredentialsProvider getBasicCredentialsProvider() {
        return basicCredentialsProvider;
    }

    /**
     * 上传文件
     *
     * @param fileDirectory /opt/tmp/xxx.file
     * @return 返回文件下载连接
     */
    public static UploadResponse upload(String fileDirectory) {
        String result = "";
        try {
            HttpPost httppost = new HttpPost(FILE_UPLOAD_GETAWAY);

            FileBody bin = new FileBody(new File(fileDirectory));

            HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.LEGACY).addPart("file", bin).setCharset(StandardCharsets.UTF_8).build();

            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = HttpClientUtil.getHttpclient().execute(httppost);
            if (HttpStatus.SC_OK == response.getCode()) {
                try {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        log.info("Response content length: " + resEntity.getContentLength());
                        result = EntityUtils.toString(resEntity, StandardCharsets.UTF_8);
                    }
                    EntityUtils.consume(resEntity);
                } catch (ParseException ignored) {
                } finally {
                    // 释放资源
                    try {
                        response.close();
                    } catch (IOException e) {
                    }
                }
            }
        } catch (IOException e) {
            log.error("apache httpclient5 upload error : {} ", ExceptionUtils.getStackTrace(e));
        }
        return JSONObject.parseObject(result, UploadResponse.class);
    }

    /**
     * 文件下载
     *
     * @param url      下载连接
     * @param fileName 文件名称
     * @return 返回文件服务器路径
     */
    public String download(String url, String fileName) {
        CloseableHttpResponse response = null;
        try {
            // 创建 HttpGet 对象
            HttpGet httpGet = new HttpGet(url);
            // 执行 Http Get 请求
            response = HttpClientUtil.getHttpclient().execute(httpGet);

            // 获取响应实体对象
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 获取输入流并且将保存下载的文件
                try (InputStream inputStream = entity.getContent(); FileOutputStream fileOutputStream = new FileOutputStream(FILE_DIRECTORY + fileName);) {
                    byte[] tmp = new byte[1024];
                    int l;
                    while ((l = inputStream.read(tmp)) != -1) {
                        fileOutputStream.write(tmp, 0, l);
                    }
                    fileOutputStream.flush();
                }
            }
            // 销毁流
            EntityUtils.consume(response.getEntity());
        } catch (IOException e) {
            log.error("download file error : {}", ExceptionUtils.getStackTrace(e));
        } finally {
            // 释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return FILE_DIRECTORY + fileName;
    }

}
