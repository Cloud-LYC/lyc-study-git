package com.lyc.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.lyc.dto.UserDTO;

import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/5/15
 * @time: 15:45
 * @desc:
 */
public class TestJson {

    public static void main(String[] args) {

        /*List<UserDTO> resource = Lists.newArrayList(UserDTO.builder().userName("1").build(),
                UserDTO.builder().userName("2").build(),
                UserDTO.builder().userName("3").build(),
                UserDTO.builder().userName("4").build(),
                UserDTO.builder().userName("5").build());

        String jsonStr = JSON.toJSONString(resource);

        List<UserDTO> result = JSON.parseArray(jsonStr, UserDTO.class);

        System.out.println(result);


        String sourceString = "{\"parkingInfo\":{\"free\":false,\"chargeInfo\":\"收费标准，每小时15元\"},\"serviceInfo\":[{\"icon\":\"https://p0.meituan.net/dpnewvc/97089d2128eb46653da120352b2b8c601393.png\",\"title\":\"1楼服务台\",\"showLocation\":false,\"iconLight\":\"https://p1.meituan.net/dpnewvc/8313ac3ba7da655967d6a5200f1dc4e42878.png\"}]}";

        JSONObject jsonObject = JSON.parseObject(sourceString);

        System.out.println("");*/



        List<String>  sources = Lists.newArrayList("1", "2", "3", "4", "5");

        System.out.println(sources.subList(0,3));



    }
}
