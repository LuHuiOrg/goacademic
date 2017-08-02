package com.lh.site.dao;

import com.lh.site.entity.StudentInfo;

public interface StudentInfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByNickNameAndPassword(StudentInfo record);
    
    StudentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}