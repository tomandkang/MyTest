package com.example.demo.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/10/13 9:42
 **/
public class StringUtils {

    /**
     * 返回中英文字符串的字节长度
     *
     * @param str
     * @return
     */
    public static int getLength(String str) {
        try {
            return str.getBytes("UTF-8").length; // 一个中文占3个字节。
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 返回中英文字符串的字节长度
     *
     * @param str
     * @return
     */
    public static int getStrLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = 0;
        for (int i=0; i<str.length(); i++ ) {
            //UTF-8编码格式中文占三个字节，GBK编码格式 中文占两个字节 ;
            len += (str.charAt(i)>255 ? 3 : 1);
        }
        return len;
    }

    /**
     * 按字节截取字符串
     * @param str
     * @param bytes
     * @return
     */
    public static String subStringByBytes(String str, int bytes) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = 0;
        for (int i=0; i<str.length(); i++ ) {
            //GBK 编码格式 中文占两个字节 UTF-8 编码格式中文占三个字节;
            len += (str.charAt(i)>255 ? 3 : 1);

            if(len>bytes){
                return str.substring(0,i);
            }
        }
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("[\"1.プレミアム素材：このクリスマステーブルランナーは高品質のリネンでできており、臭い、縮み、色落ちがなく、再利用できます。彼らは素晴らしい装飾です家、レストラン、または".getBytes("UTF-8").length); // 7

            System.out.println(subStringByBytes("[\"1.プレミアム素材：このクリスマステーブルランナーは高品質のリネンでできており、臭い、縮み、色落ちがなく、再利用できます。彼らは素晴らしい装飾です家、レストラン、またはパーティーでのクリスマスの装飾と互換性があります。\",\"2.耐久性のある使用：ユニークなクリスマスデザインと目を引くパターンを持つクリスマスホリデーテーブルランナーは、幻想的でエレガントな雰囲気を作り出すことができます。優れた印刷技術を使用しており、色あせはありません。クリスマス、パーティー、家、キッチン、レストランなどと完璧",250));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
