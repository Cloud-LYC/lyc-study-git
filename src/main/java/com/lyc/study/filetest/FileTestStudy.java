package com.lyc.study.filetest;

import java.io.File;
import java.io.FileInputStream;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/3/11
 * @time: 17:06
 * @desc:
 */
public class FileTestStudy {

    public static void main(String[] args) {

        String filePath = "/Users/liyuanchi/Desktop/Picture/1548127847564429.mp4";

        File file = new File(filePath);
        try {
            String fileName ;
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[10240];
            fis.read(buffer);
            fis.close();
            fileName = buffer.toString();
        } catch (Exception e) {

        }

        System.out.println();
    }
}
