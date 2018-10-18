package com.lyc.study.collection.Random;

import java.util.Random;
import java.util.UUID;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/10/17
 * @time: 14:32
 * @desc:
 */
public class StringRandom {

    public static void main(String[] args) {
   /*     int length = 32, n = 10;
        String baseString = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for ( int ns =10; ns >=1; ns--) {
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i <length; i++){
                int number = random.nextInt(baseString.length());
                stringBuffer.append(baseString.charAt(number));
            }
            System.out.println(stringBuffer.toString());
        }*/

        /**
         * 随机生成32位的字符串
         */
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
