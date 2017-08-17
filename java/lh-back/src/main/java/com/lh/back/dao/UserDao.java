package com.lh.back.dao;

import org.apache.ibatis.annotations.Param;

import com.lh.back.entity.User;

public interface UserDao {

	User selectByUsername(@Param("username") String username);
	
}