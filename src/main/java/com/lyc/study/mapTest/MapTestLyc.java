package com.lyc.study.mapTest;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/9/23
 * @time: 16:23
 * @desc:
 */
public class MapTestLyc {
    public static void main(String[] args) {

        List<Integer> activityTypesInt = new Gson().fromJson("[1,23,4,5]", new TypeToken<List<Integer>>(){}.getType());

        System.out.println(activityTypesInt);


        List<Map> rsult = new ArrayList<>();
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("shopid","家居安静安静");
        valueMap.put("shopname","家居安静安静");
        valueMap.put("address","家居安静安静");
        valueMap.put("shopdistrict","家居安静安静");
        valueMap.put("shopfloor","家居安静安静");
        rsult.add(valueMap);


        System.out.println(JSON.toJSONString(rsult));

    }
}
