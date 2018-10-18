package com.lyc.study.collection.enumexercise;

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 11:11 2017/12/22
 */
public enum ColorValueEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);

    private String name;
    private int code;

    private ColorValueEnum(String name, int code){
        this.name = name;
        this.code = code;
    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }


//    普通方法
    public static String getNameByCode(int code){
        for (ColorValueEnum colorValueEnum : ColorValueEnum.values() ){
            if (colorValueEnum.getCode() == code){
                return colorValueEnum.getName();
            }
        }
        return null;
    }
}
