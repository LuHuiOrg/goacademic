package com.lh.site.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.site.dao.MacMapper;
import com.lh.site.dao.StudentInfoMapper;
import com.lh.site.entity.Mac;
import com.lh.site.entity.StudentInfo;
import com.lh.site.utils.ResultUtils;
import com.lh.site.utils.ServletUtils;

@Service("StudentsService")
public class StudentsService {
	
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	@Autowired
	private MacMapper macMapper;
	
	public int addStudents(StudentInfo studentInfo){
		return studentInfoMapper.insertSelective(studentInfo);
	}
	
	public Map<String,Object> login(StudentInfo studentInfo){
		StudentInfo student = studentInfoMapper.selectByNickNameAndPassword(studentInfo);
		if(student != null){
			String macAddress = ServletUtils.getMacAddress();
			List<String> macList = macMapper.listmacByStudentInfoId(student.getId());
			if(macList.contains(macAddress)){
				return ResultUtils.buildFlagAndDataMap(true, student);
			}
			if(macList.size() < 5){
				Mac mac = new Mac();
				mac.setMac(macAddress);
				mac.setStudentId(student.getId());
				macMapper.insert(mac);
				return ResultUtils.buildFlagAndDataMap(true, student);
			}else{
				return ResultUtils.buildFlagAndMsgMap(false, "设备已达上线");
			}
		}else{
			return ResultUtils.buildFlagAndMsgMap(false, "账号或密码错误");
		}
	}
}
