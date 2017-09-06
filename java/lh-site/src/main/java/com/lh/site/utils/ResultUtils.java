package com.lh.site.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造通用结果工具，如返回flag、msg或者retCode、retMsg
 * @author carlsummer
 * @date 2017年9月5日
 * @version 1.0
 * @Copyright
 */
public class ResultUtils {

	/** 内部使用的返回标识，flag=true、false */
	public static final String FLAG = "flag";

	/** 内部使用的返回提示信息 */
	public static final String MSG = "msg";
	
	/** 内部使用的返回内容 */
	public static final String DATA = "data";
	
	/**
	 * 
	 * 构造返回结果，含flag、msg
	 *
	 * @param flag
	 * @param msg
	 * @return
	 */
	public static Map<String, Object> buildFlagAndMsgMap(boolean flag, String msg) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(FLAG, flag);
		resultMap.put(MSG, msg);
		return resultMap;
	}
	
	/**
	 * 构造返回结果，flag，data
	 * @param flag 标识
	 * @param data 信息
	 * @return 返回resultMap
	 */
	public static Map<String,Object> buildFlagAndDataMap(boolean flag,Object data){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put(FLAG,flag);
		resultMap.put(DATA, data);
		return resultMap;
	}
}
