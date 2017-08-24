package com.lh.back.utils;

import java.util.ResourceBundle;

/**
 * 配置文件获取工具类
 * @author zengxiaohui
 * @date 2017年8月24日 上午10:28:49
 * @version 1.0
 */
public class ConfigUtils {

	private static final ResourceBundle configResource = ResourceBundle.getBundle("config");
	
	/**
	 * 获取配置文件内容(config.properties)
	 * 
	 * @param key
	 *            参数key
	 * @return 参数value
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getConfig(String key) {
		return (T) configResource.getString(key);
	}

	
	/**
	 * 根据传入的fileName(不含文件后缀)，key取配置的值
	 * @param fileName
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getResource(String fileName,String key){
		ResourceBundle resource = ResourceBundle.getBundle(fileName);
		return (T) resource.getString(key);
	}
}
