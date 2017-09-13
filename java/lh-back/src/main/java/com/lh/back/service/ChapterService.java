package com.lh.back.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.back.dao.ChapterMapper;
import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Chapter;
import com.lh.back.entity.Course;
import com.lh.back.utils.ConfigUtils;
import com.lh.back.utils.SftpUtils;


@Service
public class ChapterService {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	public List<Map<String,Object>> listChapter(Chapter chapter){
		List<Map<String,Object>> chapterMapList = new ArrayList<Map<String,Object>>();
		List<Chapter> chapterList = chapterMapper.listChapter(chapter,null);
		for (Chapter chapter2 : chapterList) {
			Map<String,Object> chapterMap = new HashMap<String,Object>();
			chapterMap.put("id", chapter2.getId());
			chapterMap.put("courseId", chapter2.getCourseId());
			chapterMap.put("name", chapter2.getName());
			chapterMap.put("url", chapter2.getUrl());
			chapterMap.put("parentId", chapter2.getParentId());
			if(chapter2.getParentId() != 0){
				chapterMap.put("_parentId", chapter2.getParentId());
			}
			chapterMapList.add(chapterMap);
		}
        return  chapterMapList;
	}
	
    public boolean saveAndEditCourse(Chapter chapter){
    	if(chapter.getParentId() == null){
    		chapter.setParentId((long) 0);
    	}
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
    
    public Boolean deleteChapter(List<Long> chapterIds){
    	List<Chapter> chapterList = chapterMapper.listChapter(null, chapterIds);
    	chapterIds.clear();
    	for (Chapter chapter : chapterList) {
    		chapterIds.add(chapter.getId());
    		if(!StringUtils.isBlank(chapter.getUrl())){
    			SftpUtils.delete(ConfigUtils.getConfig("img.cover.path").toString(), chapter.getUrl());
    		}
		}
    	chapterMapper.deleteChapterByBatch(chapterIds);
    	return true;
    }
}

