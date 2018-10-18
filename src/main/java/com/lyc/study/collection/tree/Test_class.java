package com.lyc.study.collection.tree;

/**
 * Created by liyuanchi on 2017/11/27
 */
public class Test_class {
    private int a;
    private int b = 0;

    public Test_class(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Test_class{" +
                "a=" + a +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
