package com.lh.site.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.site.constant.Constant;
import com.lh.site.entity.Chapter;
import com.lh.site.entity.Order;
import com.lh.site.entity.StudentInfo;
import com.lh.site.service.CourseService;
import com.lh.site.service.OrderService;
import com.lh.site.utils.FileUtils;
import com.lh.site.utils.ServletUtils;

@Controller
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "detail")
	public String detail(Long id,ModelMap model){
		model.put("course", courseService.getCourseById(id));
		model.put("chapterListMap", courseService.listChapterByCourseId(id));
		return "course/detail";
	}
	
	@RequestMapping(value = "play",method = RequestMethod.POST)
	public String play(Chapter chapter,ModelMap model){
		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		chapter = courseService.getChapterById(chapter.getId());
		Order order = orderService.getOrderByParams(chapter.getCourseId(), studentInfo.getId());
		if (order != null) {
			ServletUtils.setSessionAttribute(Constant.PLAYCHAPTER, chapter);
			model.put("course", courseService.getCourseById(chapter.getCourseId()));
			model.put("chapterListMap", courseService.listChapterByCourseId(chapter.getCourseId()));
		}else{
			ServletUtils.removeSessionAttribute(Constant.PLAYCHAPTER);
			model.put("errorMsg", "您还没有购买此课程");
		}
		return "course/play";
	}
	
	@RequestMapping(value = "palyFlash")
	public void palyFlash(HttpServletResponse response){
		Chapter chapter = (Chapter) ServletUtils.getSessionAttribute(Constant.PLAYCHAPTER);
		if(chapter != null){
			ServletUtils.removeSessionAttribute(Constant.PLAYCHAPTER);
			FileUtils.readUrlFileToResponse(chapter.getUrl(), UUID.randomUUID().toString(), response);
		}
	}
}
