package com.lyc.study.random;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/5/31
 * @time: 10:52
 * @desc:
 */
public class RandomTest {

    /**
     * Random类中实现的随机算法是伪随机，也就是有规则的随机，实际上就是一个数字（seed）经过运算后近似随机数的数字。
     * 所以实际上伪随机是完全可以通过运算预测的。Java中的随机数种子若不填写就会使用缺省值，即系统时间。
     * @param args
     */

    public static void main(String[] args) {
 /*       Random random = new Random();

//        for (int i = 0; i < 10000; i++) {

            for (int j = 0; j < 100; j++) {
                System.out.print(random.nextInt(1) + " ");
            }
            System.out.println("\n");
//        }

//        System.out.println(i);*/



        randomGetValueForList();
    }


    /**
     * 从List中随机取值
     */
    public static void randomGetValueForList(){

        List<Integer> sourceList = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        for (int i = 0; i < 10000; i++) {
            System.out.println(sourceList.get(new Random().nextInt(sourceList.size())));

        }
    }

    /**
     * 翻转字符串
     * @param s
     */
        public void reverseString(char[] s) {
            if (s.length == 1) {
                System.out.println(s[0]);
            } else {

                reverseString(s);
            }

        }

}
