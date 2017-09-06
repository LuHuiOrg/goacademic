package com.lh.site.dao;

import org.apache.ibatis.annotations.Param;

import com.lh.site.entity.ShoppingCart;

public interface ShoppingCartMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ShoppingCart record);

	int insertSelective(ShoppingCart record);

	ShoppingCart selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ShoppingCart record);

	int updateByPrimaryKey(ShoppingCart record);

	ShoppingCart getShoppingCartByIds(@Param("courseId") Long courseId,@Param("studentInfoId") Long studentInfoId);
}