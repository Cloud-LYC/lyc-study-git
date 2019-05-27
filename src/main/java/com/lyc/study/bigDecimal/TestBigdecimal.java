package com.lyc.study.bigDecimal;


import com.lyc.dto.UserDTO;

import java.math.BigDecimal;
import java.util.Random;

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


//        dealRandom();

        addBigDecimal();
//        dealBigDecimal();

    }


    /**
     * 随机
     */

    public static void dealRandom(){
        //随机
        Random random = new Random();
        System.out.print(random.nextInt(12)+1+"\t");

        UserDTO userDto = new UserDTO();

        if (userDto.getLatitude() == 0)
            System.out.println(userDto);
    }


    /**
     * 处理BigDecimal相加
     */
    public static void addBigDecimal(){

        // 初始化
        BigDecimal source = new BigDecimal(0);
        //相加

        source = source.add(new BigDecimal(1));

        source = source.add(new BigDecimal(2.23657830));
        //输出

        System.out.println(source.floatValue());
    }


    /**
     * 处理小数位，四舍五入
     */

    public static void dealBigDecimal(){

        //首先有一个小数
        String number = "3.1415926";

        //转换成BigDecimal对象
        BigDecimal sourceBigDecimal = new BigDecimal(number);

        //保留两位 四舍五入
        BigDecimal resultBigDecimal = sourceBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

        //末尾小数点后如果都是零 则去掉 并得到float值
        float floatValue = resultBigDecimal.stripTrailingZeros().floatValue();

        System.out.println(floatValue);


    }



}
