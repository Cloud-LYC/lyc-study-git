package com.lyc.study.zipTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/14
 * @time: 13:06
 * @desc:
 */
@Slf4j
public class UnZipInputStreamTest {

    private static Pattern PIC_PATTERN = Pattern.compile("([^/]+)[/]([^/]+\\.(bmp|jpg|jpeg|png|gif))", Pattern.CASE_INSENSITIVE);


    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/liyuanchi/Desktop/Nike耐克男子连帽针织训练运动长袖开衫夹克AT3723-010.zip";
        File file = new File(path);

        try{
            ZipFile zipFile = new ZipFile(file);
            ZipArchiveInputStream inputStream = new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(file)));
            //读取压缩文件
            List<ZipArchiveEntry> zipEntryList = new ArrayList<>();
            Map<String , OutputStream> entryOS = new HashMap<>();
            ZipArchiveEntry entry;
            while((entry = inputStream.getNextZipEntry()) != null) {
                String name = entry.getName();
                if (entry.isDirectory()) {
                    File directory = new File("/Users/liyuanchi/Desktop/UnZipFiles0314", entry.getName());
                    directory.mkdirs();
                }
                if (!entry.isDirectory() && !name.startsWith("__MACOSX")) {
                    zipEntryList.add(entry);
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("/Users/liyuanchi/Desktop/UnZipFiles0314", name)));
                    /*IOUtils.copy(inputStream, os);
                    IOUtils.closeQuietly(os);*/
                    entryOS.put(name, os);
                }
            }

            //创建临时文件
            for (ZipArchiveEntry zipEntry : zipEntryList) {

            }


            //清理临时文件

            /*IOUtils.copy(inputStream, os);
            IOUtils.closeQuietly(os);*/






        }catch (Exception e){
            System.out.println("error error error");
        }

        //清除文件



    }

    private File convertTempPicFile(String picName, InputStream inputStream) {
        OutputStream ops = null;
        try {
            File picFile = File.createTempFile("temp", picName);
            ops = new FileOutputStream(picFile);
            byte[] buffer = new byte[20];
            int count;
            while ((count = inputStream.read(buffer)) != -1) {
                ops.write(buffer, 0, count);
            }
            ops.flush();
            return picFile;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }
}
