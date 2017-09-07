package com.lh.site.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.site.constant.Constant;
import com.lh.site.entity.Course;
import com.lh.site.entity.StudentInfo;
import com.lh.site.service.CourseService;
import com.lh.site.service.ShoppingCartService;
import com.lh.site.utils.ResultUtils;
import com.lh.site.utils.ServletUtils;

@Controller
@RequestMapping(value = "shop")
public class ShoppingCartController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(value = "addCart",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCart(Long courseId){
		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		Course course = courseService.getCourseById(courseId);
		if(course == null){
			return ResultUtils.buildFlagAndMsgMap(false, "该课程已经下架");
		}
		return shoppingCartService.addCourseToShoppingCart(courseId, studentInfo.getId());
	}

	@RequestMapping(value = "cart")
	public String cart(ModelMap model){
		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		model.put("listCourse", shoppingCartService.listCourseByShoppingCart(studentInfo.getId()));
		return "shop/cart";
	}
	
	@RequestMapping(value = "order")
	public String order(ModelMap model){
		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		model.put("listCourse", shoppingCartService.listCourseByShoppingCart(studentInfo.getId()));
		return "shop/order";
	}
	
	@RequestMapping(value = "payment")
	public String payment(ModelMap model){
		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		List<Course> listCourse = shoppingCartService.listCourseByShoppingCart(studentInfo.getId());
		model.put("listCourse", listCourse);
		model.put("orderCode",shoppingCartService.createOrderByShoppingCart(studentInfo.getId(),listCourse));
		return "shop/payment";
	}
}
