package com.lyc.study.threadexercise.asynchronous;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/7
 * @time: 11:05
 * @desc:
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {

        boolean r = task2();

        if(r) {
            task3();
        }

        System.out.println("------------main end-----------");
        return;
    }

    static boolean task2() throws InterruptedException {

        ExecutorDemo e = new ExecutorDemo();

        e.asynTask();

        System.out.println("------------task2 end-----------");

        return true;
    }


    static void task3() throws InterruptedException {
        int j = 0;
        while(true) {
            if(j++ > 10000) {
                break;
            }
        }

        System.out.println("------------task3 end-----------");
    }
}
