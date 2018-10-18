package com.lyc.study.bigDecimal;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/10/18
 * @time: 17:01
 * @desc:
 */
public class TestBigdecimal {
    public static void main(String[] args) {
        Random random = new Random();
        List<Double> result = new ArrayList<>();
        for (int i =0; i<= 100; i++) {
            result.add(new BigDecimal(random.nextDouble() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        Collections.sort(result);
        System.out.println(JSON.toJSON(result));
    }
}
