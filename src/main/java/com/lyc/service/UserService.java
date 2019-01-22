package com.lyc.service;

import com.lyc.dto.UserDTO;

public interface UserService {
	UserDTO selectUserById(Integer userId);
}
