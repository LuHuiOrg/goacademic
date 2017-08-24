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
	
	//跳转到注册页面
	@RequestMapping(value = "toregister", method = RequestMethod.GET)
	public String toregister(ModelMap model) {
		return "passport/register";
	}
	//跳转到登录页面
	@RequestMapping(value = "tologin",method = RequestMethod.GET)
	public String tologin(ModelMap model){
		return "passport/login";
	}
	//注销
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}
	//用户注册
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(StudentInfo studentInfo,HttpSession session){
		 studentsService.addStudents(studentInfo);
		 session.setAttribute("currentStudent", studentInfo);
		 session.setAttribute("nickname", studentInfo.getNickname());
		return "index";
	}
	//用户登录
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(StudentInfo studentInfo,HttpSession session){
		StudentInfo student = studentsService.login(studentInfo);
		if(student != null){
			session.setAttribute("currentStudent", student);
			session.setAttribute("nickname", student.getNickname());
		}else{
			
			session.setAttribute("errorMsg", "用户名或密码不正确！");
			return "passport/login";
		}
		 return "index";
	}
	
}
