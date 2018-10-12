package com.lyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.dao.UserDao;
import com.lyc.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired  
    private UserDao userDao;  
  
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
          
    } 
}
