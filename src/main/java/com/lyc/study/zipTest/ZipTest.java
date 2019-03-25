package com.lyc.study.zipTest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/7
 * @time: 17:35
 * @desc:  读取zip压缩文件内容
 */
public class ZipTest {

    static Pattern p = Pattern.compile("([^/]+)[/]([^/]+\\.(bmp|jpg|jpeg|png|gif))");

    public static void main(String[] args) throws Exception {
        String filePath = "/Users/liyuanchi/Desktop/Nike耐克男子连帽针织训练运动长袖开衫夹克AT3723-010111.zip";

        ZipFile zipFile = readZipFile(filePath);

//        ZipFile zipFile = new ZipFile(file,Charset.forName("GBK"));

        /*String encode = EncodeUtil.getEncode(file, false);
        if (StringUtils.isNotBlank(encode)){
            zipFile = new ZipFile(file, Charset.forName(encode));
        } else {
            zipFile = new ZipFile(file);
        }*/


        System.out.println(zipFile.getName());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        //读取压缩文件
        List<ZipEntry> zipEntryList = new ArrayList<>();
        while (entries.hasMoreElements()) {
            ZipEntry ze = entries.nextElement();
            String name = ze.getName();
            if (!ze.isDirectory() && !name.startsWith("__MACOSX")) {
                zipEntryList.add(ze);
                System.out.println(name);
            }
        }

    }


public static ZipFile readZipFile(String filePath) throws IOException {

    ZipFile zipFile = new ZipFile(filePath, Charset.forName("UTF-8"));
    Enumeration entriesCheck = zipFile.entries();
    while (entriesCheck.hasMoreElements()) {
        try {
            entriesCheck.nextElement();
            zipFile.close();
            zipFile = new ZipFile(filePath, Charset.forName("UTF-8"));
            return zipFile;
        } catch (Exception e) {
            zipFile = new ZipFile(filePath, Charset.forName("GBK"));
            return zipFile;
        }
    }
    return zipFile;
}




/*
    *//**
     * 传入一个文件(File)对象，检查文件编码
     *
     * @param file
     *            File对象实例
     * @return 文件编码，若无，则返回null
     * @throws FileNotFoundException
     * @throws IOException
     *//*
    public String guessFileEncoding(File file) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector());
    }

    *//**
     * <pre>
     * 获取文件的编码
     * @param file
     *            File对象实例
     * @param languageHint
     *            语言提示区域代码 @see #nsPSMDetector ,取值如下：
     *             1 : Japanese
     *             2 : Chinese
     *             3 : Simplified Chinese
     *             4 : Traditional Chinese
     *             5 : Korean
     *             6 : Dont know(default)
     * </pre>
     *
     * @return 文件编码，eg：UTF-8,GBK,GB2312形式(不确定的时候，返回可能的字符编码序列)；若无，则返回null
     * @throws FileNotFoundException
     * @throws IOException
     *//*
    public String guessFileEncoding(File file, int languageHint) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector(languageHint));
    }

    *//**
     * 获取文件的编码
     *
     * @param file
     * @param det
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     *//*
    private String guessFileEncoding(File file, nsDetector det) throws FileNotFoundException, IOException {
        // Set an observer...
        // The Notify() will be called when a matching charset is found.
        det.Init(new nsICharsetDetectionObserver() {
            public void Notify(String charset) {
                encoding = charset;
                found = true;
            }
        });

        BufferedInputStream imp = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];
        int len;
        boolean done = false;
        boolean isAscii = false;

        while ((len = imp.read(buf, 0, buf.length)) != -1) {
            // Check if the stream is only ascii.
            isAscii = det.isAscii(buf, len);
            if (isAscii) {
                break;
            }
            // DoIt if non-ascii and not done yet.
            done = det.DoIt(buf, len, false);
            if (done) {
                break;
            }
        }
        imp.close();
        det.DataEnd();

        if (isAscii) {
            encoding = "ASCII";
            found = true;
        }

        if (!found) {
            String[] prob = det.getProbableCharsets();
            //这里将可能的字符集组合起来返回
            for (int i = 0; i < prob.length; i++) {
                if (i == 0) {
                    encoding = prob[i];
                } else {
                    encoding += "," + prob[i];
                }
            }

            if (prob.length > 0) {
                // 在没有发现情况下,也可以只取第一个可能的编码,这里返回的是一个可能的序列
                return encoding;
            } else {
                return null;
            }
        }
        return encoding;
    }*/
}
