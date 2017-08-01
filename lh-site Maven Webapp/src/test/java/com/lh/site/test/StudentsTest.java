package com.lh.site.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lh.site.domain.Students;
import com.lh.site.service.StudentsService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({ "classpath:spring-datasource-core.xml" })
public class StudentsTest {
	
	@Autowired
	private StudentsService studentsService;
	
	@Test
	public void testAddStudents() {
		Students students = new Students();
		students.setNickName("renault");
		students.setPassword("123");
		System.out.println(studentsService.login(students).toString());

	}

}
