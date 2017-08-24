package com.lh.back.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.lh.back.entity.Course;
import com.lh.back.service.CourseService;
import com.lh.back.utils.ConfigUtils;
import com.lh.back.utils.ResultUtils;
import com.lh.back.utils.SftpUtils;

@Controller
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String course(){
		return "course/list";
	}
	
	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(Course course,Integer page,Integer rows){
		Map<String,Object> resutlMap = new HashMap<String,Object>();
		PageInfo<Course> pageInfo = courseService.pageCourse(course,page,rows);
		resutlMap.put("rows", pageInfo.getList());
		resutlMap.put("total", pageInfo.getTotal());
		resutlMap.put("firstPage", pageInfo.getFirstPage());
		return resutlMap;
	}
	
	@RequestMapping(value = "save",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(Course course,@RequestParam("coverFile") CommonsMultipartFile coverFile){
		try {
			if(coverFile != null && !coverFile.isEmpty()){
				String fileName = SftpUtils.getNewFilename(coverFile.getOriginalFilename());
				String uploadCourseCover = ConfigUtils.getConfig("img.cover.path") + fileName;
				String deleteFullFilename = course.getCover();
				course.setCover(ConfigUtils.getConfig("img.domain").toString()+ConfigUtils.getConfig("img.cover.web.path").toString()+fileName);
				SftpUtils.uploadSFtp(uploadCourseCover, coverFile.getInputStream(), deleteFullFilename);// 上传最新图片
			}
			if(!courseService.saveAndEditCourse(course)){
				return ResultUtils.buildFlagAndMsgMap(false, "保存数据失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return ResultUtils.buildFlagAndMsgMap(true, "");
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(String ids){
		List<Long> courseIds = JSONArray.parseArray(ids,long.class);
		if(courseService.deleteCourseByBatch(courseIds)){
			return ResultUtils.buildFlagAndMsgMap(true, "");
		}else{
			return ResultUtils.buildFlagAndMsgMap(false, "保存数据失败");
		}
	}
}
