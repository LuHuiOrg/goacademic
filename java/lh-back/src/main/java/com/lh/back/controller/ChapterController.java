package com.lh.back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lh.back.entity.Chapter;
import com.lh.back.entity.Course;
import com.lh.back.service.ChapterService;
import com.lh.back.service.CourseService;
import com.lh.back.utils.ConfigUtils;
import com.lh.back.utils.ResultUtils;
import com.lh.back.utils.SftpUtils;

@Controller
@RequestMapping(value = "chapter")
public class ChapterController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String chapter(Long courseId,ModelMap model){
		Course course = new Course();
		course.setId(courseId);
		model.put("course", chapterService.showCourseAndChapter(course));
		return "course/chapter";
	}
	
	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(Chapter chapter,Integer page,Integer rows){
		Map<String,Object> resutlMap = new HashMap<String,Object>();
		resutlMap.put("rows", chapterService.listChapter(chapter));
		return resutlMap;
	}
	
	@RequestMapping(value = "save",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(Chapter chapter,@RequestParam("chapterVideo") CommonsMultipartFile chapterVideo){
		try{
			if(chapterVideo != null && !chapterVideo.isEmpty()){
				String fileName = SftpUtils.getNewFilename(chapterVideo.getOriginalFilename());
				String uploadChapterVideo = ConfigUtils.getConfig("img.cover.path") + fileName;
				String deleteFullFilename = chapter.getUrl();
				chapter.setUrl(ConfigUtils.getConfig("img.domain").toString()+ConfigUtils.getConfig("img.cover.web.path").toString()+fileName);
				SftpUtils.uploadSFtp(uploadChapterVideo, chapterVideo.getInputStream(), deleteFullFilename);// 上传最新图片
			}
			if(!chapterService.saveAndEditCourse(chapter)){
				return ResultUtils.buildFlagAndMsgMap(false, "保存数据失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResultUtils.buildFlagAndMsgMap(true, "");
	}

}
