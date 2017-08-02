package com.lh.site.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lh.site.entity.StudentInfo;
import com.lh.site.service.StudentsService;
import com.lh.site.test.common.BaseTest;

public class StudentsTest extends BaseTest{

	@Autowired
	private StudentsService studentsService;
	
	/*@Test
	public void testAddStudents() {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setNickname("renault");
		studentInfo.setPassword("125553");
		studentInfo.setEmail("2362651588@qq.com");
		studentInfo.setMobile("13776060074");
		System.out.println(studentsService.addStudents(studentInfo));

	}*/
	
	@Test
	public void testLogin(){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setNickname("renault");
		studentInfo.setPassword("123");
		System.out.println(studentsService.login(studentInfo).toString());
		
	}
}
