package com.lh.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.back.utils.UserUtils;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping(value = "/back/index",method = RequestMethod.GET)
	public String indexBack(ModelMap model){
		model.put("sysUserName", UserUtils.getPrincipal());
		return "index";
	}
	
	@RequestMapping(value ="/welcome",method = RequestMethod.GET)
	public String welcome(){
		return "welcome";
	}

}
