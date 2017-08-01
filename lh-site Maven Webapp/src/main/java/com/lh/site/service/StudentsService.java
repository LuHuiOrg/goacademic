package com.lh.site.service;

import com.lh.site.domain.Students;

public interface StudentsService {
	/**
	 * 登陆
	 * @param students
	 * @return
	 */
	public Students login(Students students);
	/**
	 * 注册用户
	 * @param students
	 * @return
	 */
	public Integer addStudents(Students students);

}
