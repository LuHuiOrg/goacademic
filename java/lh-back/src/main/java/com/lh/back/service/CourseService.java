package com.lh.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Course;

@Service
public class CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	public List<Course> listCourse(Course course){
		return courseMapper.listCourse(course);
	}
	
	public void saveAndEditCourse(Course course){
		if (course.getId() == null) {
			courseMapper.insert(course);
		}else{
			courseMapper.updateByPrimaryKey(course);
		}
	}
	
	public void deleteCourseByBatch(List<Long> courseIds){
		courseMapper.deleteCourseByBatch(courseIds);
	}
}
