package com.example.demo.TestClass;

import org.springframework.web.util.HtmlUtils;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/1/29 9:08
 **/
public class Test4Class {

    private static String regEx_html="<[^>]+>";

    public static void main(String[] args) {
        String str="<p>Features:</p><p>1. Best quality multi-function carpet.</p><p>2. Material: Synthetic area rugs.</p><p>3. It is easy to install, use, and clean.</p><div><br></div>";
        String[] split =str.split(regEx_html);
        if(split!=null&&split.length>=2){
            if(split.length>=2){
              //  HtmlUtils.removeSpace(split[1]);
                System.out.println(split[1]);
            }
            if(split.length>=3){
                System.out.println(split[2]);
            }
            if(split.length>=4){
                System.out.println(split[3]);
            }
            if(split.length>=5){
                System.out.println(split[4]);
            }
            if(split.length>=6){
                System.out.println(split[5]);
            }
        }
    }


}
