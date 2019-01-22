package com.lyc.entity;

import lombok.Data;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/1/22
 * @time: 17:01
 * @desc: 用户实体Bean
 */
@Data
public class UserEntity{
    /**
     * 数据库自增Id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 横坐标
     */
    double longitude;

    /**
     * 纵坐标
     */
    double latitude;
}
