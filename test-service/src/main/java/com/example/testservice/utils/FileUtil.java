package com.example.testservice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

/**
 * @Auther: wuxin
 * @Date: 2019/6/3:20:26
 * @Description:
 */
public class FileUtil {

    private static Logger LOGGER = LogManager.getLogger(FileUtil.class);

    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            return false;
        }
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                return false;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }


    public static boolean createFiles(String fileName) {
        try {
            String filePath = fileName.substring(0, fileName.lastIndexOf("/"));
            Files.createDirectories(Paths.get(filePath));
            if (!Files.exists(Paths.get(fileName))) {
                Files.createFile(Paths.get(fileName));
            }
        } catch (IOException e) {
            LOGGER.error("创建文件失败", e);
            return false;
        }
        return true;
    }


    public static void saveToImgByBytes(String filePath, String imageLink) throws IOException {
        try {

            Files.createDirectories(Paths.get(filePath));
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
            }

            byte[] bytes = Files.readAllBytes(Paths.get(imageLink));
            Files.write(Paths.get(filePath), bytes);
        } catch (Exception ie) {
            ie.printStackTrace();
            throw new IOException("图片下载失败", ie);
        }
    }

    /**
     * 复制单个文件
     *
     * @param oldPathFile 准备复制的文件源
     * @param newPathFile 拷贝到新绝对路径带文件名
     * @return
     */
    public static void copyFile(String oldPathFile, String newPathFile) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPathFile);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPathFile); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPathFile);
                byte[] buffer = new byte[10485760];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            LOGGER.error("复制单个文件操作出错", e);
        }
    }

    /**
     * 删除目录下所以文件
     *
     * @param file
     */
    public static boolean delFile(File file) {
        try {
            if (!file.exists()) {
                return false;
            }

            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    delFile(f);
                }
            }
            return file.delete();
        } catch (Exception e) {
            return false;
        }

    }


    public static String unzipGz(FileInputStream fin, String... charSet) throws IOException {
        //建立gzip解压工作流
        try (GZIPInputStream ginzip = new GZIPInputStream(fin)) {
            byte[] buffer = new byte[1024];
            int offset;
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                while ((offset = ginzip.read(buffer)) != -1) {
                    out.write(buffer, 0, offset);
                }
                if (charSet != null && charSet.length > 0) {
                    return out.toString(charSet[0]);
                }
                return out.toString("UTF-8");
            }
        }
    }


    public static void test(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fi = new FileInputStream(file);) {
            int len = 0;
            byte bytearr[] = new byte[1024];
            while ((len = fi.read(bytearr)) != -1) {
                sb.append(new String(bytearr, 0, len));
            }
        } catch (Exception e) {
        }
        System.out.println("读取的文件内容为：" + sb.toString());    //将字节型数组转换为字符串
    }

    public static void test1(File file) throws Exception {
        StringBuilder result = new StringBuilder();
        String str = null;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader);) {
            str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                result.append(str);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(new File(filePath));
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(reader)) {
            String jsonStr;
            while ((jsonStr = br.readLine()) != null) {
                System.out.println(jsonStr);
            }
        } catch (Exception e) {
        }
    }

}
