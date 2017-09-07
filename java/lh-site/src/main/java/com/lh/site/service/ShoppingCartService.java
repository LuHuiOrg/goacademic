package com.lh.site.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lh.site.dao.CourseMapper;
import com.lh.site.dao.OrderItemMapper;
import com.lh.site.dao.OrderMapper;
import com.lh.site.dao.ShoppingCartMapper;
import com.lh.site.entity.Course;
import com.lh.site.entity.Order;
import com.lh.site.entity.OrderItem;
import com.lh.site.entity.ShoppingCart;
import com.lh.site.utils.DateUtils;
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
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
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
	
	@Transactional(readOnly = false)
	public String createOrderByShoppingCart(Long studentInfoId,List<Course> courseList){
		//判断购物车中是否有商品
		if(courseList.size() > 0){
			List<OrderItem> orderItemList = new ArrayList<OrderItem>();
			BigDecimal orderAmount = BigDecimal.ZERO;
			String orderCode = DateUtils.getOrderNum();
			for (Course course : courseList) {
				orderAmount = orderAmount.add(course.getPrice());
				OrderItem orderItem = new OrderItem();
				orderItem.setCourseId(course.getId());
				orderItem.setOrderCode(orderCode);
				orderItemList.add(orderItem);
			}
			Order order = new Order();
			order.setOrderCode(orderCode);
			order.setStudentInfoId(studentInfoId);
			order.setOrderAmount(orderAmount);
			order.setPayType(0);
			order.setPayStatus(0);
			order.setCreateTime(new Date());
			order.setRemarks("来自网页订单");
			orderMapper.insert(order);
			orderItemMapper.insertByBatch(orderItemList);
			shoppingCartMapper.deleteByStudentInfoId(studentInfoId);
			return orderCode;
		}else{
			return null;
		}
	}
	
}
