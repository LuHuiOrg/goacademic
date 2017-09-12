package com.lh.back.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.back.dao.ChapterMapper;
import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Chapter;
import com.lh.back.entity.Course;


@Service
public class ChapterService {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	public List<Chapter> listChapter(Chapter chapter){
		List<Chapter> chapterList = chapterMapper.listChapter(chapter);
        return  chapterList;
	}
	
    public boolean saveAndEditCourse(Chapter chapter){
    	int changeCount = 0;
    	if (chapter.getId() == null) {
			changeCount = chapterMapper.insertSelective(chapter);
		}else{
			changeCount = chapterMapper.updateByPrimaryKeySelective(chapter);
		}
    	return (changeCount > 0) ? true : false;
    }

    public Map<String,Object> showCourseAndChapter(Course course){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("course", courseMapper.getCourseByCourse(course));
		resultMap.put("bigChapterList", chapterMapper.listBigChapter(course.getId()));
		return resultMap;
	}
}

