package com.lyc.study.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Auther: liyuanchi
 * Mail: liyuanchi@meituan.com
 * DateTime: 2018/1/25 17:42
 * Project:
 */
public class TestSubList {
    public static void main(String[] args) {
        List<Integer> sourceList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11));

        int totalSize = sourceList.size();
        int remainder = totalSize / 5;

        System.out.println("余数:"+remainder);
        int toIndex;

        if (10 + 10 > totalSize){
            toIndex = 10 + remainder;
        }else {
            toIndex = 6 + 5;
        }

        List<Integer> list1 = sourceList.subList(0,5);
        List<Integer> list2 = sourceList.subList(10,toIndex);

        System.out.println(list1);

        System.out.println(list2);


        /*Date date = new Date(0);
        System.out.println(date.getTime());*/


    }
}
