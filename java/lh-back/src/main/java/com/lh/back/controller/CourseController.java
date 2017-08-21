package com.lh.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "course")
public class CourseController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String course(){
		return "course/list";
	}
}
