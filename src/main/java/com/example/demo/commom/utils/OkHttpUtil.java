package com.example.demo.commom.utils;


import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class OkHttpUtil {


    private static final MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

    private OkHttpUtil() {
    }

    public static OkHttpClient getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private OkHttpClient singleton;

        Singleton() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(5L, TimeUnit.SECONDS);
            builder.readTimeout(5L, TimeUnit.SECONDS);
            builder.writeTimeout(5L, TimeUnit.SECONDS);
            ConnectionPool connectionPool = new ConnectionPool(50, 60, TimeUnit.SECONDS);
            builder.connectionPool(connectionPool);
            singleton = builder.build();
        }

        public OkHttpClient getInstance() {
            return singleton;
        }
    }

    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = getInstance().newCall(request).execute()) {
            return response.body().string();
        }
    }


}

