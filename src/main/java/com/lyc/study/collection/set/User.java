package com.lyc.study.collection.set;

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 15:10 2017/12/21
 */
public class User {
    private String userName;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
