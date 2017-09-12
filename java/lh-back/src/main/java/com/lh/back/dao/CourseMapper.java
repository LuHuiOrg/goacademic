package com.lh.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lh.back.entity.Course;

public interface CourseMapper {

    int insertSelective(Course record);

    Course getCourseByCourse(Course course);

    int updateByPrimaryKeySelective(Course record);

    List<Course> listCourse(@Param("record") Course record,@Param("courseIds") List<Long> courseIds);
    
    int deleteCourseByBatch(@Param("courseIds") List<Long> courseIds); 
}