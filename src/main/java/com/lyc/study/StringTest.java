package com.lyc.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.json.JSONTokener;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/8
 * @time: 20:14
 * @desc:
 */
public class StringTest {
    public static void main(String[] args) {


       /* String name = "王小二哈哈哈哈";
        String replaceAll = name.replaceAll("(?<=.{1}).(?=.{1})", "*");


        String a = "2";
 *//*       String b = "2";
        String c = new String("2");
        String d = new String("2");

        boolean aR = a == "2";

        System.out.println(aR);
        System.out.println(a == b);
        System.out.println(a == c);*//*

//        System.out.println(getEquals(a));

       *//* System.out.println(String.format("%.3f", 0.124213));

        System.out.println(String.format("%."+ 11 + "f", Math.random()).replaceFirst("0.", ""));
*//*

//        System.out.println(54/12);

      *//* String test = "[123,23]";

        Object stringJson = new JSONTokener(test).nextValue();

        if (stringJson instanceof JSONArray){
            System.out.println("shcdiudsbui");
        }*//*


        *//*List<String> strings = JSON.parseArray("[1111,1860214,1863157,1946092,2036581,2061523,2086513,2124904,2281726,2298196,2315659,2368135,2887450,2966398,3186190,3570985,3591895,4014655,4015687,4121983,4221144,4517519,5265444,5353325,5446720,5584360,8941056,15947277,16817111,18677651,21285477,21382258,22132248,22681179,23002291,23894237,24304811,24654131,24740427,24923640,26211411,27131620,27238989,37805391,50330996,56588006,58012533,58039963,63218225,65495623,65984253,66818166,67372801,68545872,69412468,69755329,70428525,73508852,80060090,82381359,82609472,82610107,82640721,82642132,82643630,82653081,82653208,82654300,82768484,82770056,82770076,82827398,83175002,83175005,83175010,83175026,83175027,83175048,83175060,83178003,83178008,83181267,83181268,83181269,83181270,83181271,83181272,83181273,83181274,83181275,83181282,83181283,83181284,83181290,83181353,83181354,83183038,83183039,83183040,83183041,83183042,83184022,83184023,83185015,83185042,83185043,83185044,83186001,83186018,83186019,83186020,83186021,83186022,83186023,83186024,83186026,83186030,83190014,83190015,83190016,83191002,83191003,83191004,83191006,83192010,83192017,83192019,83192053,83192060,83192077,83286316,83296220,83310121,83445856,83445857,83448411,150009146,150033386,150033388,150035021,150035967,150035968,150049131,150049680,150050057,150050582,150050583,150050593,150051013,150051014,150060096,150060097,150066016,150066020,150066033,150066035,150066041,150066043,150066047,150067214,150067215,150067220,150067221,150067238,150067293,150067294,150067297,150067332,150078024]").toJavaList(String.class);
        System.out.println(strings);*//*


        String newString = "o'2nd";
        String oldString = "o'2nd";

        String validText = pickValidText(oldString, newString, false);

        System.out.println(StringUtils.isBlank(validText));*/


        getslip();

    }

    /**
     * @param oldText    原值
     * @param newText    新值
     * @param allowEmpty 是否允许新值为空串， 新值为空串表示更新数据时会更细为空串，即去除poi属性
     * @return null则poi报错不处理该字段
     */
    private static String pickValidText(String oldText, String newText, boolean allowEmpty) {
        boolean notNullOrBlank = allowEmpty ? newText != null : StringUtils.isNotBlank(newText);
        if (notNullOrBlank && !"null".equals(newText) && !"undefined".equals(newText) && !newText.equals(oldText)) {
            return newText;
        }
        return null;
    }


    public  static boolean getEquals(String value){
        boolean result = value == "2";
        return result;
    }



    public static void getslip(){
        String soap = "[{1,73},{2,466},{3,1387},{4,2950},{5,1690},{6,959}]";
//        String s = soap.replaceAll("\\{", "#");


        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
    }





}
