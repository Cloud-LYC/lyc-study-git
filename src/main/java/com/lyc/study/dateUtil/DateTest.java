package com.lyc.study.dateUtil;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/8/17
 * @time: 14:28
 * @desc:
 */
public class DateTest {

    private static final ThreadLocal<Map<String, SimpleDateFormat>> map;

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String MM_SS_MM_DD = "mm:ss dd/MM";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String HH_MM = "HH:mm";

    static {
        map = ThreadLocal.withInitial(() -> new HashMap<>());
    }



    public static void main(String[] args) {

        String print = DateTimeFormat.forPattern("yyyy-MM-dd").print(DateTime.now().withTimeAtStartOfDay().withDayOfWeek(3));
        DateTime dateTime = DateTime.now().withTimeAtStartOfDay().withDayOfWeek(3);

        System.out.println(print);

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

    //判断传入的时间list是否在最近5周周末
    @Test
    public void testDate(){

        //构造入参
        List<String> weekenddate = new ArrayList<>();

        weekenddate.add("2018-11-18");
        weekenddate.add("2018-11-11");
        weekenddate.add("2018-11-04");
        weekenddate.add("2018-10-28");
        weekenddate.add("2018-11-21");

        if (CollectionUtils.isEmpty(weekenddate) || weekenddate.size() > 4){
            return;
        }

        for (String date : weekenddate) {
            boolean isTrueDate = false;
            for (int i = 1; i <= 5 ; i++) {
                if (DateTimeFormat.forPattern("yyyy-MM-dd").print(DateTime.now().withTimeAtStartOfDay().minusWeeks(i).withDayOfWeek(7)).equals(date)){
                    isTrueDate = true;
                    break;
                }
            }
            if (isTrueDate)
                continue;
            else {
                System.out.println("时间错误"+date);
                return;
            }
        }

        System.out.println("Hello World!");

    }



    @Test
    public void testGetStratrTime(){

        Date date = new Date();
        date.setTime(1543055592428l);
        String time = "10:00:00";

        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD);//设置日期格式
        Date parse = parse(df.format(date) + " " + time, YYYY_MM_DD_HH_MM_SS);


        System.out.println(parse.toString());
    }



    public static Date parse(String date, String format) {

        SimpleDateFormat sdf = getSdf(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SimpleDateFormat getSdf(String format) {
        SimpleDateFormat sdf = map.get().get(format);
        if (sdf == null) {
            sdf = new SimpleDateFormat(format);
            map.get().put(format, sdf);
        }
        return sdf;
    }
}
