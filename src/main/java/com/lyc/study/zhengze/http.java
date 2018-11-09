package com.lyc.study.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/4
 * @time: 19:21
 * @desc:
 */
public class http {

    public static void main(String[] args) {
        String patt = "^(http|https)://";
        // 用于测试的输入字符串
        String input = "https://www.baidu.com";
        // 从正则表达式实例中运行方法并查看其如何运行
        System.out.println(input.replaceFirst("https","https"));
        System.out.println(input.replace("http","https"));


        String str = new String();
        boolean contains = str.contains("233");

        System.out.println(contains);

    }
}
