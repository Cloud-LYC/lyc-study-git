package com.lyc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/1/22
 * @time: 17:04
 * @desc: 用户实体DTO
 */
@Data
public class UserDTO implements Serializable {
    /**
     * 序列化serialVersionUID
     */
    private static final long serialVersionUID = 4377278047707242247L;
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