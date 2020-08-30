package com.lyc.study.leetcode.no434;

import org.apache.commons.lang.StringUtils;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/8/21
 * @time: 21:16
 * @desc:
 */
public class CountSegments {

    public static void main(String[] args) {

        int i = countSegments("Hello,      my name is John");

        System.out.println(i);

    }

    /**
     * 错误
     * @param s
     * @return
     */
    public static int countSegments1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        return s.split(" ").length;
    }


    public static int countSegments(String s) {
        char space = ' ';
        int count = 0;
        if (s == null || s.length() <= 0) {
            return count;
        }
        s += " ";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != space && chars[i +1] == space) {
                count ++;
            }
        }
        return count;
    }

}
