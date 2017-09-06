package com.lh.site.dao;

import java.util.List;

import com.lh.site.entity.Course;

public interface CourseMapper {

    Course selectByPrimaryKey(Long id);

    List<Course> listCourse();
    
    List<Course> listCourseByShoppingCart(Long studentInfoId);
}