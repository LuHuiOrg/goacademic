package com.lh.site.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.site.constant.Constant;
import com.lh.site.entity.StudentInfo;
import com.lh.site.service.StudentsService;
import com.lh.site.utils.ResultUtils;
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
	public String register(StudentInfo studentInfo){
		studentsService.addStudents(studentInfo);
		return "passport/login";
	}
	//用户登录
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(StudentInfo studentInfo,ModelMap model){
		Map<String,Object> resultMap = studentsService.login(studentInfo);
		if(ResultUtils.getFlag(resultMap)){
			ServletUtils.setSessionAttribute(Constant.STUDENTINFO, (StudentInfo)ResultUtils.getData(resultMap));
		}else{
			model.put("errorMsg", ResultUtils.getMsg(resultMap));
			return "passport/login";
		}
		return "redirect:/";
	}
	
}
