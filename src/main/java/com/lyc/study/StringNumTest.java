package com.lyc.study;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/25
 * @time: 13:46
 * @desc:  判断java String字符串是否为数字
 */
public class StringNumTest {


    public static void main(String[] args) {
        String a = "-123.456";
        String b = "-12s3";
        String c = "12s3.456";

        List<String> source  = new ArrayList<>();

        source.add(a);
        source.add(b);
        source.add(c);

        for (String s : source) {
            System.out.println(isDouble(s));
        }

    }

    //判断整数（int）
    private static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    //判断字符串是否为浮点数（double和float）
    private static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }
}
