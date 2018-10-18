package com.lyc.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        /*for (DepthActionTypeEnum depth: DepthActionTypeEnum.values()
             ) {
            System.out.println(depth.getName());
        }*/
        String name = DepthActionTypeEnum.fromName("trade.1").name();

        System.out.println(DepthActionTypeEnum.valueOf(name));

        Map<String,List<String>> actionType = new HashMap<String, List<String>>();

        actionType.put("trade", Arrays.asList("1","2","3"));
        actionType.put("collect", Arrays.asList("shop"));
        actionType.put("share", Arrays.asList("shop"));
        actionType.put("scanshop", null);
        actionType.put("scan", Arrays.asList("dish","review"));
        actionType.put("openmap", null);

        for (Map.Entry<String, List<String>> action : actionType.entrySet()
                ) {
            String key = action.getKey();
            List<String> value = action.getValue();

            System.out.println("----"+key+"-----"+value);
        }
    }
}
