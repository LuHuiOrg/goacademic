package com.lh.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.site.dao.OrderMapper;
import com.lh.site.entity.Order;

@Service(value = "OrderService")
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	public Order getOrderByParams(Long courseId,Long studentInfoId){
		return orderMapper.getOrderByParams(courseId, studentInfoId);
	}

}
