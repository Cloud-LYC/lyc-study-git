package com.lyc.utils;


import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/1
 * @time: 11:41
 * @desc:
 */
public class MobileNoUtils {
    private final static String REGEX="[`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）_——+|{}【】‘；：”“’。，、？]";

    public static void main(String[] args) {
        String mobileNoEncrypt = getMobileNoEncrypt("15000#997413");
        System.out.println(mobileNoEncrypt);
    }
    /**
     * 手机号中间四位*号替换
     */
    public static String getMobileNoEncrypt(String mobileNo){
        if (StringUtils.isEmpty(mobileNo)) {
            mobileNo = "12345678910";
        }
        if (mobileNo.length() >= 8){
            return mobileNo.substring(0,mobileNo.length()-8)+"****"+mobileNo.substring(mobileNo.length()-4, mobileNo.length());
        }
        return mobileNo;
    }
/*    public static String getMobileNoEncrypt(String mobileNo){
        if (StringUtils.isEmpty(mobileNo)) {
            mobileNo = "15000997413";
        }

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(mobileNo);
        String resultStr = matcher.replaceAll("").trim();

        if (resultStr.length() >= 8){
            return resultStr.substring(0,resultStr.length()-8)+"****"+resultStr.substring(mobileNo.length()-4, resultStr.length());
        }
        return resultStr;
    }*/
}
