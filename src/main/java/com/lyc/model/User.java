package com.lyc.model;

import lombok.Data;

@Data
public class User {
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
}
