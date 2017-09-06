package com.lh.site.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.site.constant.Constant;
import com.lh.site.entity.StudentInfo;
import com.lh.site.service.StudentsService;
import com.lh.site.utils.ServletUtils;

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
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String tologin(ModelMap model){
		return "passport/login";
	}
	//注销
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(){
		ServletUtils.removeSessionAttribute(Constant.STUDENTINFO);
		ServletUtils.removeSessionAttribute(Constant.REQ_URL);
		return "redirect:login?urlactive=login";
	}
	//用户注册
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(StudentInfo studentInfo,HttpSession session){
		studentsService.addStudents(studentInfo);
		ServletUtils.setSessionAttribute(Constant.STUDENTINFO, studentInfo);
		return "index";
	}
	//用户登录
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(StudentInfo studentInfo,ModelMap model){
		StudentInfo student = studentsService.login(studentInfo);
		if(student != null){
			ServletUtils.setSessionAttribute(Constant.STUDENTINFO, student);
		}else{
			model.put("errorMsg", "用户名或密码不正确！");
			return "passport/login";
		}
		return "redirect:/";
	}
	
}
