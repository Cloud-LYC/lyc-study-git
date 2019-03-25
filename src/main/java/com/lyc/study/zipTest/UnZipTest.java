package com.lyc.study.zipTest;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/13
 * @time: 21:43
 * @desc:
 */
public class UnZipTest {
    public static void main(String[] args) throws Exception{
        String path = "/Users/liyuanchi/Desktop/Nike耐克男子连帽针织训练运动长袖开衫夹克AT3723-010.zip";
        unzip(new File(path), "/Users/liyuanchi/Desktop/UnZipFiles0314");
    }

    public static void unzip(File zipFile, String descDir) {
        try (ZipArchiveInputStream inputStream = getZipFile(zipFile)) {
            File pathFile = new File(descDir);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            ZipArchiveEntry entry = null;
            while ((entry = inputStream.getNextZipEntry()) != null) {
                if (entry.isDirectory()) {
                    File directory = new File(descDir, entry.getName());
                    directory.mkdirs();
                } else {
                    OutputStream os = null;
                    try {
                        os = new BufferedOutputStream(new FileOutputStream(new File(descDir, entry.getName())));
                        //输出文件路径信息
                        System.out.println("解压文件的当前路径为:{}"+ descDir + entry.getName());
                        IOUtils.copy(inputStream, os);
                    } finally {
                        IOUtils.closeQuietly(os);
                    }
                }
            }
            final File[] files = pathFile.listFiles();
            if (files != null && files.length == 1 && files[0].isDirectory()) {
                /*// 说明只有一个文件夹
                FileUtils.copyDirectory(files[0], pathFile);
                //免得删除错误， 删除的文件必须在/data/demand/目录下。
                boolean isValid = files[0].getPath().contains("/data/www/");
                if (isValid) {
                    FileUtils.forceDelete(files[0]);
                }*/
            }
            System.out.println("******************解压完毕********************");

        } catch (Exception e) {
            System.out.println("[unzip] 解压zip文件出错"+ e);
        }
    }

    private static ZipArchiveInputStream getZipFile(File zipFile) throws Exception {
        return new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
    }
}
