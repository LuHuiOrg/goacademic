package com.lh.site.dao;

import com.lh.site.entity.Mac;

public interface MacMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mac record);

    int insertSelective(Mac record);

    Mac selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mac record);

    int updateByPrimaryKey(Mac record);
}