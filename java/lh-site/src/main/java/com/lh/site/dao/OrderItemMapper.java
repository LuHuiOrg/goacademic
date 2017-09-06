package com.lh.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lh.site.entity.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
    
    int insertByBatch(@Param("orderItemList") List<OrderItem> orderItemList);
}