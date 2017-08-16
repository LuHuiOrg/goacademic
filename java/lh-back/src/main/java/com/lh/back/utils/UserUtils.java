package com.lh.back.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户工具类
 * 
 * @author carlsummer
 * @date 2016年12月19日
 * @version 1.0
 * @Copyright
 */
public class UserUtils {

	private static final Logger logger = LoggerFactory.getLogger(UserUtils.class);
	
	/**
	 * 获取当前登录者登录名
	 */
	public static String getPrincipal(){
		try {
			return (String) SecurityUtils.getSubject().getPrincipal();
		} catch (Exception e) {
			logger.error("获取principa异常",e);
		}
		return null;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
}
