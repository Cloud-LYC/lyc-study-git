package com.lyc.study.collection.enumexercise;

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 17:54 2017/12/21
 */
public class EnumTest {

    public static void main(String[] args) {

//        1、基本使用

//        获取color枚举成员
/*        System.out.println(ColorEnum.valueOf("RED"));
        System.out.println(ColorEnum.RED);
        System.out.println(ColorEnum.values().length);*/

//        2、向枚举中添加新方法 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。

        for (int i = 0; i < ColorValueEnum.values().length; i++) {
            System.out.println("Code = " +i+" Value="+ColorValueEnum.getNameByCode(i));
        }
//       3、meiju


    }
}
