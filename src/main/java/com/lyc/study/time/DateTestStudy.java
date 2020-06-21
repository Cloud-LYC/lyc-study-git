package com.lyc.study.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/6/21
 * @time: 22:55
 * @desc:
 */
public class DateTestStudy {
    public static void main(String[] args) {

        /**
         * HH是24小时制，hh是12小时制
         * 区别就是：大写的H是二十四小时制的小时数(0-23)，小写的h是十二小时制的小时数(am/pm 1-12)
         */

        //24小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //12小时制
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1 = "2020-06-21 16:45:12";
        try {
            sdf.parse(date1);
            System.out.println(sdf.format(sdf.parse(date1))); //2020-06-21 16:45:12
            System.out.println(sdf1.format(sdf.parse(date1))); //2020-06-21 04:45:12
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /**
         * Java里面MM表示月 mm表示分钟 HH表示 24小时制 hh表示12小时制
         *         Oracle里面 mm表示月 mi表示分钟 hh24表示小时
         *         mm与m等，它们的区别为是否有前导零：H,m,s表示非零开始，HH,mm,ss表示从零开始。
         *         比如凌晨1点2分，HH:mm显示为01:02，H:m显示为1:2。
         */

    }
}
