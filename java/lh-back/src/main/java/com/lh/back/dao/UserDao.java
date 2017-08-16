package com.lh.back.dao;

import java.util.Set;

import com.lh.back.entity.User;

public interface UserDao {
	/**
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);
	
	/**
	 * @return
	 */
	Set<String> selectRolesByUsername();

	/**
	 * @return
	 */
	Set<String> selectPermissionsByUsername();
	
}