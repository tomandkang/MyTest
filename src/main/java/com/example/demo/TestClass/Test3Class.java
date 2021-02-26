package com.example.demo.TestClass;





import com.example.demo.ObjectTest.Father;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/1/22 10:58
 **/
public class Test3Class {


    private static String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
    private static String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
    private static String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
    private static String regEx_space="&nbsp;*";

    public static void main(String[] args) {

        String str="very well";
        String s = removeHtmlTag(str);
        System.out.println(s);
    }


    /**
     * 过滤html标签
     * @param htmlStr
     * @return
     */
    public static String removeHtmlTag(String htmlStr){

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        Pattern p_space=Pattern.compile(regEx_space,Pattern.CASE_INSENSITIVE);//过滤&nbsp;*标签
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(" ");

        return htmlStr.trim(); //返回文本字符串
    }
}
