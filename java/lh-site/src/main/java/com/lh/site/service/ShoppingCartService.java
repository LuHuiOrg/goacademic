package com.lh.site.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.site.dao.CourseMapper;
import com.lh.site.dao.ShoppingCartMapper;
import com.lh.site.entity.Course;
import com.lh.site.entity.ShoppingCart;
import com.lh.site.utils.ResultUtils;

/**
 * @author carlsummer
 * @date 2017年9月5日
 * @version 1.0
 * @Copyright
 */
@Service(value = "ShoppingCartService")
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	public Map<String,Object> addCourseToShoppingCart(Long courseId,Long studentInfoId){
		ShoppingCart shoppingCart = shoppingCartMapper.getShoppingCartByIds(courseId, studentInfoId);
		if(shoppingCart == null){
			shoppingCart = new ShoppingCart();
			shoppingCart.setCourseId(courseId);
			shoppingCart.setStudentInfoId(studentInfoId);
			shoppingCart.setCreateTime(new Date());
			if(shoppingCartMapper.insertSelective(shoppingCart)>0){
				return ResultUtils.buildFlagAndMsgMap(true, "已经成功加入购物车");
			}else{
				return ResultUtils.buildFlagAndMsgMap(false, "网络异常请重试");
			}
		}else{
			return ResultUtils.buildFlagAndMsgMap(false, "此课程已在购物车中");
		}
	}
	
	public List<Course> listCourseByShoppingCart(Long studentInfoId){
		return courseMapper.listCourseByShoppingCart(studentInfoId);
	}
}
