package com.lh.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "course")
public class CourseController {

	@RequestMapping(value = "detail")
	public String detail(){
		return "course/detail";
	}
	
	@RequestMapping(value = "play")
	public String play(){
		return "course/play";
	}
}
