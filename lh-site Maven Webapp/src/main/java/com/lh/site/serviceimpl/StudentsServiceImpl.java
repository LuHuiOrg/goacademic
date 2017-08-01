package com.lh.site.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lh.site.dao.StudentsDao;
import com.lh.site.domain.Students;
import com.lh.site.service.StudentsService;

@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {

	@Resource
	private StudentsDao studentsDao;
	@Override
	public Students login(Students students) {
		return studentsDao.login(students);
	}

	@Override
	public Integer addStudents(Students students) {
		return studentsDao.addStudents(students);
	}

}
