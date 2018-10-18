package com.lyc.study.collection.map;

import com.lyc.study.collection.DepthAction.UserDepthActionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/9/25
 * @time: 11:09
 * @desc:
 */
public class HashMapTest {

    /**
     * remove test
     */

    public static void main(String[] args) {
/*        Map<Integer, String> mapResult = new HashMap<>();

        //添加一个元素
        mapResult.put(1,"a");
        mapResult.put(2,"b");
        mapResult.put(3,"c");

        //根据Key遍历
        Set<Integer> keySet = mapResult.keySet();
        System.out.println("删除之前：");
        for (Integer key: keySet) {
            System.out.println("Key: "+key+"   Value:"+mapResult.get(key));
        }

        System.out.println("删除1,2两个元素:");
        mapResult.remove(1);
        mapResult.remove(2);
        keySet = mapResult.keySet();
        for (Integer key: keySet) {
            System.out.println("Key: "+key+"   Value:"+mapResult.get(key));
        }

        System.out.println("删除3元素:");
        keySet = mapResult.keySet();
        mapResult.remove(3);
        for (Integer key: keySet) {
            System.out.println("Key: "+key+"   Value:"+mapResult.get(key));
        }*/

        List<UserDepthActionDto> dtoList = new ArrayList<>();
        for (UserDepthActionDto dto : dtoList) {
            System.out.println(dto.getName());
        }



    }


}
