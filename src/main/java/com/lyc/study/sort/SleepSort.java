package com.lyc.study.sort;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/9
 * @time: 15:04
 * @desc: 睡觉排序，哈哈哈，，，真要是这么写要被LayOff的
 */
public class SleepSort implements Runnable{

    private String num;

    public SleepSort(int num){
        this.num = num + "";
    }

    public static void main(String[] args) {

        int[] nums = {11, 3, 998, 5455, 1, 2, 4, 4, 152, 990};
        for (int i = 0; i < nums.length; i++) {
            new Thread((new SleepSort(nums[i]))).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
