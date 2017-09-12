package com.lh.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lh.back.entity.Chapter;

public interface ChapterMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
    
    //章节列表
    List<Chapter> listChapter(@Param("record") Chapter record);
    //批量删除章节
    int deleteChapterByBatch(@Param("chapterIds") List<Long> chapterIds); 
    
    List<Chapter> listBigChapter(@Param("courseId") Long courseId);
    
}