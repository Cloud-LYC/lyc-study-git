package com.lyc.study.jvmstudy;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 */


public class ClassA {
    public static int m = ClassB.m;

    public static int n = 10;

    public static void main(String[] args) {
        System.out.println("m: " + m + ", n: " + n);
//        Main main = new Main();
//        System.out.println(main.inc());
    }

}
