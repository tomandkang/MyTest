package com.example.demo.commom.constant;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/14 17:53
 * @description
 */
public class EmailHostConstant {

    /**
     * imap 协议邮箱对应 host
     */
    static Map<String, String> IMAP_EMAIL_HOST = new HashMap<>();

    /**
     * smtp 协议邮箱对应 host
     */
    static Map<String, String> SMTP_EMAIL_HOST = new HashMap<>();

    /**
     * sina 服务对应 host
     */
    static List<String> SINA_SERVER = new ArrayList<>();

    public static String getImap(String key) {
        if (!StringUtils.hasText(key)) {
            return null;
        }
        return IMAP_EMAIL_HOST.get(key);
    }

    public static String getSmtp(String key) {
        if (!StringUtils.hasText(key)) {
            return null;
        }
        return SMTP_EMAIL_HOST.get(key);
    }

    public static List<String> getSinaServer() {
        return SINA_SERVER;
    }

    static {
        IMAP_EMAIL_HOST.put("@outlook.com", "outlook.office365.com");
        IMAP_EMAIL_HOST.put("@hotmail.com", "outlook.office365.com");
        IMAP_EMAIL_HOST.put("@gmail.com", "imap.gmail.com");
        IMAP_EMAIL_HOST.put("@qq.com", "imap.qq.com");
        IMAP_EMAIL_HOST.put("@163.com", "imap.163.com");
        IMAP_EMAIL_HOST.put("@126.com", "imap.126.com");
        IMAP_EMAIL_HOST.put("@yeah.net", "imap.yeah.net");
        IMAP_EMAIL_HOST.put("@sina.com", "imap.sina.com");
        IMAP_EMAIL_HOST.put("@sina.cn", "imap.sina.cn");
        IMAP_EMAIL_HOST.put("@139.com", "imap.139.com");
        IMAP_EMAIL_HOST.put("@kokoerp.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@youkeshu.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@vvgetbuy.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@wwdobuy.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@sanbaok.shop", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@jektionc.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@darwinsely.com", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@alljoynay.store", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@dolwisian.store", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@blueblue.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@bdzaizai.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@budingbaby.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@xbdbaby.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@kittybuding.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@cutecute.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@lovehouse.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@kimil.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@enjoyyy.top", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@plautosleepy.vip", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@tutemantan.vip", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@vermicelli.vip", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@store-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@store-support.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@shop-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@replyline.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@customerline.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@better-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@mmail-wowway.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@ligele-wowway.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@buy-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@buy-support.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@reply-studio.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@office-reply.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@customer-studio.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@chatclick.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@ostudio-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@studio-support.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@station-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@station-support.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@mall-service.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@mall-support.net", "imap.exmail.qq.com");
        IMAP_EMAIL_HOST.put("@traversemarket.com", "imap.exmail.qq.com");

        SMTP_EMAIL_HOST.put("@outlook.com", "smtp.office365.com");
        SMTP_EMAIL_HOST.put("@hotmail.com", "smtp.office365.com");
        SMTP_EMAIL_HOST.put("@gmail.com", "smtp.gmail.com");
        SMTP_EMAIL_HOST.put("@qq.com", "smtp.qq.com");
        SMTP_EMAIL_HOST.put("@163.com", "smtp.163.com");
        SMTP_EMAIL_HOST.put("@126.com", "smtp.126.com");
        SMTP_EMAIL_HOST.put("@yeah.net", "smtp.yeah.net");
        SMTP_EMAIL_HOST.put("@sina.com", "smtp.sina.com");
        SMTP_EMAIL_HOST.put("@sina.cn", "smtp.sina.cn");
        SMTP_EMAIL_HOST.put("@139.com", "smtp.139.com");
        SMTP_EMAIL_HOST.put("@kokoerp.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@youkeshu.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@vvgetbuy.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@wwdobuy.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@sanbaok.shop", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@jektionc.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@darwinsely.com", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@alljoynay.store", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@dolwisian.store", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@blueblue.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@bdzaizai.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@budingbaby.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@xbdbaby.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@kittybuding.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@cutecute.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@lovehouse.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@kimil.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@enjoyyy.top", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@plautosleepy.vip", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@tutemantan.vip", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@vermicelli.vip", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@store-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@store-support.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@shop-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@replyline.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@customerline.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@better-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@mmail-wowway.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@ligele-wowway.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@buy-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@buy-support.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@reply-studio.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@office-reply.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@customer-studio.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@chatclick.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@ostudio-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@studio-support.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@station-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@station-support.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@mall-service.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@mall-support.net", "smtp.exmail.qq.com");
        SMTP_EMAIL_HOST.put("@traversemarket.com", "smtp.exmail.qq.com");

        SINA_SERVER.add("imap.163.com");
        SINA_SERVER.add("imap.126.com");
        SINA_SERVER.add("imap.yeah.net");
        SINA_SERVER.add("imap.sina.com");
        SINA_SERVER.add("imap.sina.cn");
    }
}
