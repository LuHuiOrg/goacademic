package com.lh.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.site.dao.CourseMapper;
import com.lh.site.entity.Course;

@Service("CourseService")
public class CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	public PageInfo<Course> listCourse(Integer pageNum){
		pageNum = pageNum != null ? pageNum : 1;
		PageHelper.startPage(pageNum, 10, true);
		List<Course> courseList = courseMapper.listCourse();
		return new PageInfo<Course>(courseList);
	}
	
	public Course getCourseById(Long courseId){
		return courseMapper.selectByPrimaryKey(courseId);
	}
}
