package com.lh.back.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.back.dao.UserDao;
import com.lh.back.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User queryByUsername(String username) {
		return userDao.selectByUsername(username);
	}

}
