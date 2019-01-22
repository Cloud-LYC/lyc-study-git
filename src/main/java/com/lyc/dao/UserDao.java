package com.lyc.dao;

import com.lyc.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	/**
	 * 根据userId单个查询
	 * @param userId
	 * @return
	 */
	UserEntity selectUserById(@Param("userId") int userId);
}
