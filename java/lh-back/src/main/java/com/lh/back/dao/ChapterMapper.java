package com.lh.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lh.back.entity.Chapter;

public interface ChapterMapper {
	
    int insertSelective(Chapter record);

    int updateByPrimaryKeySelective(Chapter record);

    //章节列表
    List<Chapter> listChapter(@Param("record") Chapter record,@Param("chapterIds") List<Long> chapterIds);
    //批量删除章节
    int deleteChapterByBatch(@Param("chapterIds") List<Long> chapterIds); 
    
    List<Chapter> listBigChapter(@Param("courseId") Long courseId);
    
}