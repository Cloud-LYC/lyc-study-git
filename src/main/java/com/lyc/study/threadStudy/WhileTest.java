package com.lyc.study.threadStudy;

import com.lyc.study.threadexercise.TestThread;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/8/24
 * @time: 10:20
 * @desc:
 */
public class WhileTest {

    public static void main(String[] args) throws InterruptedException {
        //死循环测试
        Thread.sleep(5000);

        for (int i = 0; i < 5; i++) {
            TestThread testThread = new TestThread();
            testThread.start();
        }

        Thread.sleep(50000);

    }
}
