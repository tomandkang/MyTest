package com.example.demo.HttpRequestTest;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpClientUtils {

    
    private static void httpGetTest1(String url){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute =null;
        try {
            execute = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = execute.getEntity();
            System.out.println("响应状态为:" +execute.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (execute != null) {
                    execute .close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void httpGetTest2(String url){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringBuffer params = new StringBuffer();
        try {
            params.append("name=" + URLEncoder.encode("&", "utf-8"));
            params.append("&");
            params.append("age=24");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }








    }


}
