package com.lyc.study.collection.mana;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liyuanchi on 2017/11/28
 */
public class mafka {
    public static void main(String[] args) {

        Map<Integer,Integer> map = getMapInteger(1,2);

        Set a = map.keySet();
        System.out.println(a.getClass()+" :  "+map.values().getClass());

    }

    public static Map<Integer,Integer> getMapInteger(int a, int b){
        Map<Integer,Integer> map = new HashMap<>();

        map.put(a,b);
        return map;
    }


}
