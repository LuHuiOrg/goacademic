package com.lh.back.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.back.dao.ChapterMapper;
import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Chapter;
import com.lh.back.entity.pojo.ChapterPojo;


@Service
public class ChapterService {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	//存放转换后数据的集合 
	
	
	public PageInfo<ChapterPojo> pageChapter(Chapter chapter,Integer pageNum,Integer pageSize){
		pageNum = pageNum != null ? pageNum : 1;
		pageSize = pageSize != null ? pageSize : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		/*List<Chapter> chapterList = chapterMapper.listChapter(chapter);*/
		/*chapterToChapter(chapterList);*/
		List<ChapterPojo> chapterPojoList = new ArrayList<ChapterPojo>(); 
		ChapterPojo chapterPojo = new ChapterPojo();
		   chapterPojo.setId(1L);
	        chapterPojo.setCourseName("111");
	        chapterPojo.setName("111");
	        chapterPojo.setParent_id(-1L);
	        chapterPojo.set_parentId(-1L);
	        chapterPojo.setUrl("111"); 
	        chapterPojoList.add(chapterPojo);
		return new PageInfo<ChapterPojo>(chapterPojoList);
	}



 
	
    public List<Chapter> findChapters(Map<String, Object> map) {

        return chapterMapper.findChapters(map);
    }

    public List<ChapterPojo> findChapterPojos(Map<String, Object> map) {
    	List<Chapter> chpaterList  = chapterMapper.findChapters(map);
    	List<ChapterPojo> chpaterPojoList  = new ArrayList<ChapterPojo>();
    	for(int i = 0; i<chpaterList.size(); i++){
    		ChapterPojo chapterPojo = new ChapterPojo();
    		chapterPojo.setId(chpaterList.get(i).getId());
    		chapterPojo.setName(chpaterList.get(i).getName());
    		Long parentId = chpaterList.get(i).getParentId();
    		if(parentId == -1){
    			String courseName = courseMapper.selectByPrimaryKey(chpaterList.get(i).getId()).getName();
        		chapterPojo.setCourseName(courseName);
    		}else{
    			chapterPojo.setParent_id(parentId);
        		chapterPojo.set_parentId(parentId);
    		}
    		chapterPojo.setUrl(chpaterList.get(i).getUrl());
    		chpaterPojoList.add(chapterPojo);
    	}
    	
        return chpaterPojoList;
    }

    public Integer getCount(Map<String, Object> map) {

        return chapterMapper.getCount(map);
    }
	
}
