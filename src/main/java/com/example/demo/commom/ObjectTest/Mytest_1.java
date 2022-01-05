package com.example.demo.commom.ObjectTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/22 16:09
 **/
public class Mytest_1 {


    public static void main(String[] args)throws Exception{
        while(true){
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            System.out.println(s.getInetAddress().getHostAddress() + "....connected");
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            // 给客户端一个反馈信息
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            System.out.println("欢迎使用myTomcat服务器");
            s.close();
            ss.close();
        }

    }

}
