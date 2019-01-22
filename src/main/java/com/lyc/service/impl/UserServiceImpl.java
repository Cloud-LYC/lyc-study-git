package com.lyc.service.impl;

import com.lyc.dto.UserDTO;
import com.lyc.entity.UserEntity;
import com.lyc.service.UserService;
import com.lyc.utils.Copier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired  
    private UserDao userDao;  
  
    public UserDTO selectUserById(Integer userId) {

        UserEntity userEntity = userDao.selectUserById(userId);
        if (userEntity != null) {
            /**
             * 类型转换 entity--> dto
             */
            UserDTO userDTO = Copier.to(UserDTO.class).from(userEntity);
            return userDTO;
        }
        return null;
    } 
}
