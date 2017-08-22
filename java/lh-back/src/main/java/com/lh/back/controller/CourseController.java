package com.lh.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.lh.back.entity.Course;
import com.lh.back.service.CourseService;

@Controller
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String course(){
		return "course/list";
	}
	
	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(Course course){
		Map<String,Object> resutlMap = new HashMap<String,Object>();
		resutlMap.put("rows", courseService.listCourse(course));
		return resutlMap;
	}
	
	@RequestMapping(value = "save",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(Course course){
		courseService.saveAndEditCourse(course);
		return null;
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(String ids){
		List<Long> courseIds = JSONArray.parseArray(ids,long.class);
		courseService.deleteCourseByBatch(courseIds);
		return null;
	}
}
