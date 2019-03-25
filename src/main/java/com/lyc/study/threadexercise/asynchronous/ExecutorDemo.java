package com.lyc.study.threadexercise.asynchronous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/3/7
 * @time: 11:05
 * @desc:
 */
public class ExecutorDemo {
    private ExecutorService executor = Executors.newFixedThreadPool(1);

    public void asynTask() throws InterruptedException {


        executor.submit(new Runnable() {

            @Override
            public void run() {

                try {
                    Thread.sleep(10000);//方便观察结果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int sum = 0;
                for(int i = 0; i < 1000; i++) {

                    sum += i;
                }

                System.out.println(sum);
            }
        });
        return;
    }

}
