package com.lh.back.service.sys;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.back.dao.UserDao;
import com.lh.back.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * @param username
	 * @return
	 */
	public User queryByUsername(String username) {
		return userDao.selectByUsername(username);
	}

	/**
	 * @param username
	 * @return
	 */
	public Set<String> getRoles(String username) {
		return userDao.selectRolesByUsername();
	}

	/**
	 * @param username
	 * @return
	 */
	public Set<String> getPermissions(String username) {
		return userDao.selectPermissionsByUsername();
	}
}
