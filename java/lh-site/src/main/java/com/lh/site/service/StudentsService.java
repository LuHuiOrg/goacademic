package com.lh.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.site.dao.StudentInfoMapper;
import com.lh.site.entity.StudentInfo;

@Service("StudentsService")
public class StudentsService {
	
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	public int addStudents(StudentInfo studentInfo){
		return studentInfoMapper.insertSelective(studentInfo);
	}
	
	public StudentInfo login(StudentInfo studentInfo){
		return studentInfoMapper.selectByNickNameAndPassword(studentInfo);
		
	}
}
