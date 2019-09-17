package com.lyc.study.dateUtil;

import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/8/28
 * @time: 20:05
 * @desc:
 */
public class MothTest {

    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -6);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String monthfirst = format.format(c.getTime());
        System.out.println("===============nowfirst:" + monthfirst);

//获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String monthlast = format.format(ca.getTime());
        System.out.println("===============last:" + monthlast);

    }
}
