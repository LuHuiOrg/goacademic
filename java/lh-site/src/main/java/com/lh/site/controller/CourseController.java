package com.lh.site.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.site.entity.Chapter;
import com.lh.site.service.CourseService;
import com.lh.site.utils.FileUtils;

@Controller
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "detail")
	public String detail(Long id,ModelMap model){
		model.put("course", courseService.getCourseById(id));
		model.put("chapterListMap", courseService.listChapterByCourseId(id));
		return "course/detail";
	}
	
	@RequestMapping(value = "play",method = RequestMethod.POST)
	public String play(Chapter chapter,ModelMap model){
		model.put("course", courseService.getCourseById(chapter.getCourseId()));
		model.put("chapterListMap", courseService.listChapterByCourseId(chapter.getCourseId()));
		return "course/play";
	}
	
	@RequestMapping(value = "palyFlash")
	public void palyFlash(HttpServletResponse response){
		FileUtils.readUrlFileToResponse("http://47.92.123.48/images/cover/f1c3140516~1.flv", UUID.randomUUID().toString(), response);
	}
}
