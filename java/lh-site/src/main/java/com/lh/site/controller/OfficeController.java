package com.lh.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "office")
public class OfficeController {

	@RequestMapping(value = "myCourse")
	public String myCourse(){
		return "office/my_course";
	}
}
