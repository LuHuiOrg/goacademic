package com.lh.back.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Course;
import com.lh.back.utils.ConfigUtils;
import com.lh.back.utils.SftpUtils;

@Service
public class CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	public PageInfo<Course> pageCourse(Course course,Integer pageNum,Integer pageSize){
		pageNum = pageNum != null ? pageNum : 1;
		pageSize = pageSize != null ? pageSize : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<Course> courseList = courseMapper.listCourse(course,null);
		return new PageInfo<Course>(courseList);
	}
	
	public boolean saveAndEditCourse(Course course){
		int changeCount = 0;
		if (course.getId() == null) {
			changeCount = courseMapper.insertSelective(course);
		}else{
			changeCount = courseMapper.updateByPrimaryKeySelective(course);
		}
		return (changeCount > 0) ? true : false;
	}
	
	public boolean deleteCourseByBatch(List<Long> courseIds){
		List<Course> courseList = courseMapper.listCourse(null,courseIds);
		courseMapper.deleteCourseByBatch(courseIds);
		for (Course course : courseList) {
			if(!StringUtils.isBlank(course.getCover())){
				SftpUtils.delete(ConfigUtils.getConfig("img.cover.path").toString(), course.getCover());
			}
		}
		return true;
	}
	
}
