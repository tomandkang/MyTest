package com.example.demo.commom.files;


import java.io.*;

public class FilesUtil {

    public static void main(String[] args)throws Exception{
        File file = new File("D:\\测试文件夹\\62b5699e3b34ab2d0448c077.ndjson");
        test1(file);
    }

    public static void test(File file){
        StringBuilder sb = new StringBuilder();
        try(FileInputStream fi = new FileInputStream(file);) {
            int len=0;
            byte bytearr[] = new byte[1024];
            while ((len = fi.read(bytearr))!=-1){
                sb.append(new String(bytearr,0,len));
            }
        } catch (Exception e) {
        }
        System.out.println("读取的文件内容为："+sb.toString());	//将字节型数组转换为字符串
    }

    public static void test1(File file)throws Exception{
        StringBuilder result = new StringBuilder();
        String str= null;
        try(FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);) {
            str = null;
            while ((str=br.readLine())!=null){
                System.out.println(str);
                result.append(str);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
