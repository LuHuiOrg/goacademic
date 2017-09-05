package com.lh.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lh.site.entity.Course;
import com.lh.site.service.CouseService;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	
	@Autowired
	private CouseService couseService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model,Integer pageNum) {
		PageInfo<Course> pageInfo = couseService.listCourse(pageNum);
		model.put("pageInfo", pageInfo);
		return "index";
	}
}
