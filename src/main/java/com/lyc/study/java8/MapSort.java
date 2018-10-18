package com.lyc.study.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Intellij IDEA.
 * Auther: liyuanchi
 * Date: 2018/3/21
 * Time: 14:45
 * Project:
 *
 * @copyright www.dianping.com
 */
public class MapSort {
    public static void main(String[] args) {
        HashMap friends = new HashMap<>();

        friends.put(1,1521614453000L);
        friends.put(2,null);
        friends.put(3,1519195253000L);
        friends.put(4,1521528053000L);
        friends.put(5,1521898053000L);
        friends.put(89,3678L);
        friends.put(7,null);

        ArrayList result = new ArrayList<>();

//        friends.entrySet().stream()
//                .filter(friend -> friend.getValue()!=null)
//                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
//                .forEach(e -> result.add(e.getKey()));
//
//
//
//        result.subList(0,3).forEach(e -> System.out.println(e));


    }
}
