package com.lh.site.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lh.site.domain.Students;
@Repository
public interface StudentsDao {

	/**
	 * 登陆
	 * @param student
	 * @return
	 */
	@Transactional("read")
	public Students login(Students students);
	/**
	 * 注册用户
	 * @param student
	 * @return
	 */
	public Integer addStudents(Students students);
}
