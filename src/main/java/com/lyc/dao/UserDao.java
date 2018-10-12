package com.lyc.dao;

import com.lyc.model.User;

public interface UserDao {
	public User selectUserById(Integer userId);  
}
