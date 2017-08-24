package com.lh.back.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {

	
	/** 内部使用的返回标识，flag=true、false */
	public static final String FLAG = "flag";
	
	/** 内部使用的返回提示信息 */
	public static final String MSG = "msg";
	
	/**
	 * 构造返回结果，flag，msg
	 * @param flag 标识
	 * @param msg 信息提示
	 * @return 然后resultMap
	 */
	public static Map<String,Object> buildFlagAndMsgMap(boolean flag,String msg){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put(FLAG,flag);
		resultMap.put(MSG, msg);
		return resultMap;
	}
}
