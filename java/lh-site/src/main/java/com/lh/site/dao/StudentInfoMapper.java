package com.lh.site.dao;

import com.lh.site.entity.StudentInfo;

public interface StudentInfoMapper {
	
    int insertSelective(StudentInfo record);

    StudentInfo selectByNickNameAndPassword(StudentInfo record);
    
}