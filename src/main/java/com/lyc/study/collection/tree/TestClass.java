package com.lyc.study.collection.tree;

/**
 * Created by liyuanchi on 2017/11/27
 */
public class TestClass {
    public static void main(String[] args) {

        Test_class test_class = getInteger(1);
        System.out.println(test_class);



    }

    public static Test_class getInteger(int n){
        if (n == 1) {
            return new Test_class(1);
        }else {
            return new Test_class(2);
        }
    }
    public static Test_class setInteger(int m){
        return new Test_class(2);
    }
}
