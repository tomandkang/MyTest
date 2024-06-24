package com.example.demo.commom.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-06-21  14:38
 * @Description:
 * @Version: 1.0
 */
public class MD5Util {
    public static void main(String[] args) {
        String message = "Hello, World!";

        try {
            // 创建MD5消息摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算消息的摘要
            byte[] digest = md.digest(message.getBytes());

            // 将摘要转换为十六进制字符串
            String hexString = bytesToHex(digest);

            System.out.println("MD5 Digest: " + hexString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
