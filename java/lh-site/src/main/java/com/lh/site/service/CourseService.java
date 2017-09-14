package com.lh.site.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.site.dao.ChapterMapper;
import com.lh.site.dao.CourseMapper;
import com.lh.site.entity.Chapter;
import com.lh.site.entity.Course;

@Service("CourseService")
public class CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	public PageInfo<Course> listCourse(Integer pageNum){
		pageNum = pageNum != null ? pageNum : 1;
		PageHelper.startPage(pageNum, 9, true);
		List<Course> courseList = courseMapper.listCourse();
		return new PageInfo<Course>(courseList);
	}
	
	public Course getCourseById(Long courseId){
		return courseMapper.selectByPrimaryKey(courseId);
	}
	
	public List<Map<String,Object>> listChapterByCourseId(Long courseId){
		List<Chapter> chapterList = chapterMapper.listChapterByCourseId(courseId);
		//将父子节点拆分
		List<Chapter> sonChapterList = new ArrayList<Chapter>();
		List<Chapter> parentChapterList = new ArrayList<Chapter>();
		for (Chapter chapter : chapterList) {
			if (chapter.getParentId() != 0) {
				sonChapterList.add(chapter);
			}else{
				parentChapterList.add(chapter);
			}
		}
		//封装成页面需要的数据
		List<Map<String,Object>> chapterListMap = new ArrayList<Map<String,Object>>();
		for (Chapter parentChapter : parentChapterList) {
			Map<String,Object> chapterMap = new HashMap<String,Object>();
			chapterMap.put("parentChapter", parentChapter);
			List<Chapter> childrenList = new ArrayList<Chapter>();
			for (Chapter sonChapter : sonChapterList) {
				if(sonChapter.getParentId() == parentChapter.getId()){
					childrenList.add(sonChapter);
				}
			}
			chapterMap.put("childrenList", childrenList);
			chapterListMap.add(chapterMap);
		}
		return chapterListMap;
	}
	
	public Chapter getChapterById(Long chapterId){
		return chapterMapper.selectByPrimaryKey(chapterId);
	}
}
