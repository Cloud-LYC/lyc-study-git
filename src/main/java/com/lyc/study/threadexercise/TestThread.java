package com.lyc.study.threadexercise;

import java.util.Date;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/1/22
 * @time: 17:53
 * @desc: 多线程练习
 */

public class TestThread extends Thread{
    private Thread t;
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (true) {
            System.out.println(i);
            i++;
        }
    }

    @Override
    public synchronized void start() {
        if (t != null) {
            t.start();
        }
    }
}
