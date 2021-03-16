package com.example.demo.TestClass;


import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/3/1 18:07
 **/
public class Test8Class {


    public static void main(String[] args) throws Exception {
        standardHTML(new File("D:\\test\\123.html"));
        htmlToPdf(new File("D:\\test\\123.html"),"D:\\test\\sjsjsj.pdf");
    }




        /**
         * html转换成PDF
         * @param htmlFile html文件
         * @param pdfPath  pdf路径
         * @throws Exception 异常
         */
        public static void htmlToPdf(File htmlFile, String pdfPath) throws Exception {

            OutputStream os = new FileOutputStream(pdfPath);
            ITextRenderer iTextRenderer = new ITextRenderer();
            iTextRenderer.setDocument(htmlFile);

            //解决中文编码
            ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
            if ("linux".equals(getCurrentOperationSystem())) {
                fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            } else {
                fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            }

            iTextRenderer.layout();
            iTextRenderer.createPDF(os);
            os.flush();
            os.close();
        }

        private static String getCurrentOperationSystem() {
            String os = System.getProperty("os.name").toLowerCase();
            return os;
        }

    private static void standardHTML(File f) throws IOException {

    }




}
