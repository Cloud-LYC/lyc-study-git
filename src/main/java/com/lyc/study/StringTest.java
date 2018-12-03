package com.lyc.study;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/8
 * @time: 20:14
 * @desc:
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "2";
 /*       String b = "2";
        String c = new String("2");
        String d = new String("2");

        boolean aR = a == "2";

        System.out.println(aR);
        System.out.println(a == b);
        System.out.println(a == c);*/

//        System.out.println(getEquals(a));

        System.out.println(String.format("%.3f", 0.124213));

        System.out.println(String.format("%."+ 11 + "f", Math.random()).replaceFirst("0.", ""));

    }


    public  static boolean getEquals(String value){
        boolean result = value == "2";
        return result;
    }
}
