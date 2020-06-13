package com.lyc.study.collection.set;

import lombok.Data;
import lombok.experimental.Builder;

import java.util.Date;

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 15:10 2017/12/21
 */
@Builder
public class User {
    private String userName;
    private int age;
    private Date birth;

    public User() {

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

    public User(String userName, int age, Date birth) {
        this.userName = userName;
        this.age = age;
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
