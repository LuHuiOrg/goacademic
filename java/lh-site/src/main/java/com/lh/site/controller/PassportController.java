package com.lh.site.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.site.entity.StudentInfo;
import com.lh.site.service.StudentsService;

@Controller
@RequestMapping(value = "passport")
public class PassportController{
	
	@Resource
	private StudentsService studentsService;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		return "passport/register";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(ModelMap model){
		return "passport/login";
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public String addStudent(StudentInfo studentInfo,HttpSession session){
		 int resultTotal = 0;
		 resultTotal = studentsService.addStudents(studentInfo);
		 session.setAttribute("currentStudent", studentInfo);
		 session.setAttribute("nickname", studentInfo.getNickname());
		return "index";
	}
	
}
