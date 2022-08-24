package com.example.demo.commom.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class GoogleTranslateUtil {

    /**
     * @param content 批量 翻译的内容数据，默认翻译成英文
     * @param tl      目标语言 @link https://cloud.google.com/translate/docs/languages
     * @return
     * @throws IOException
     */
    public static List<String> translateContent(List<String> content, String tl) {
        FormBody.Builder builder = new FormBody.Builder();
        content.forEach(c -> builder.add("q", c));
        String url = "https://clients5.google.com/translate_a/t?client=dict-chrome-ex&sl=auto&tl=";
        if (StringUtils.hasText(tl)) {
            url += tl;
        } else {
            url += "en";
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        try (Response response = OkHttpUtil.getInstance().newCall(request).execute()) {
            if (response.isSuccessful()) {
                String result = response.body().string();
                List<List> lists = JSONObject.parseArray(result, List.class);
                List<String> data = lists.stream().map(x -> x.size() > 0 ? x.get(0).toString() : "").collect(Collectors.toList());
                return data;
            } else {
                return null;
            }
        } catch (IOException e) {
            log.error("google translate fail", e);
            throw new RuntimeException(e);
        }
    }
}
