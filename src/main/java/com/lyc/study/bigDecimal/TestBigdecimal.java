package com.lyc.study.bigDecimal;

import com.lyc.model.User;

import java.util.Random;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/10/18
 * @time: 17:01
 * @desc:
 */
public class TestBigdecimal {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print(random.nextInt(12)+1+"\t");

        User user = new User();

        if (user.getLatitude() == 0)
        System.out.println(user);

    }


}
