package com.lh.site.dao;

import java.util.List;

import com.lh.site.entity.Chapter;

public interface ChapterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
    
    List<Chapter> listChapterByCourseId(Long courseId);
}