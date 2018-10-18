package com.lyc.study.dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/8/17
 * @time: 14:28
 * @desc:
 */
public class DateTest {
    public static void main(String[] args) {

        //String Time
        String activateDay = "2018-08-16";
        try {
            long activateTime = new SimpleDateFormat("yyyy-MM-dd").parse(activateDay).getTime();
            long nowTime = System.currentTimeMillis();
            long resultTime = nowTime - activateTime;

            if ( resultTime <= 259200000) {
                System.out.println(true);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}
