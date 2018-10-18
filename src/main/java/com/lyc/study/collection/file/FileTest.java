package com.lyc.study.collection.file;

import java.io.*;

/**
 * create by Intellij IDEA.
 * Auther: liyuanchi
 * Date: 2018/3/21
 * Time: 17:31
 * Project:
 *
 * @copyright www.dianping.com
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //加载本地文件
        FileReader sourceFile = new FileReader("/Users/liyuanchi/Desktop/2333.txt");

        //按行读取

        int count = 0;

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(sourceFile);

        String str = null;
        while ((str = br.readLine()) != null && count <= 10000){
            str = str+",";
            sb.append(str);
            count ++;
        }

        br.close();
        sourceFile.close();

        // write string to file
        FileWriter writer = new FileWriter("/Users/liyuanchi/Desktop/test.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(sb.toString());

        bw.close();
        writer.close();


        //追加保存到新文件，
    }
}
