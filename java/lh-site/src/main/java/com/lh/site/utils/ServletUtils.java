package com.lh.site.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * servlet工具类
 * 
 * @author zengxiaohui
 * @date 2017年2月18日 下午14:36:15
 * @version 1.0
 */
public class ServletUtils {

	/** http协议可能被负载均衡隐藏 */
	private static final String httpProtocol = "http";

	/**
	 * 获取当前请求对象
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取Session对象
	 * 
	 * @return session
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 设置Session值
	 * 
	 * @param id
	 *            要存储到session中的名字
	 * @param value
	 *            要存储到session中的值
	 */
	public static void setSessionAttribute(String id, Object value) {
		getSession().setAttribute(id, value);
	}

	/**
	 * 清空Session值
	 * 
	 * @param id
	 *            要清除session中值的名字
	 */
	public static void removeSessionAttribute(String id) {
		if (StringUtils.isNotEmpty(id)) {
			getSession().removeAttribute(id);
		}
	}

	/**
	 * 取得Session的值
	 * 
	 * @param id
	 *            要得到session中的值的名字
	 * @return 返回session中的值
	 */
	public static Object getSessionAttribute(String id) {
		return getSession().getAttribute(id);
	}

	/**
	 * 获取request 请求URL
	 * 
	 * @return 返回请求的url
	 */
	public static String getUrl() {
		String queryString = getRequest().getQueryString();
		if (StringUtils.isEmpty(queryString)) {
			return getRequest().getRequestURL().toString();
		}
		return getRequest().getRequestURL().append("?").append(queryString).toString();
	}

	/**
	 * 
	 * 获取请求url
	 *
	 * @return 返回request中的uri
	 */
	public static String getRequestURI() {
		return getRequest().getRequestURI();
	}

	/**
	 * 获得用户远程地址
	 * 
	 * @return 返回用户的远程地址
	 */
	public static String getRemoteAddr() {
		return getRemoteAddr(getRequest());
	}

	/**
	 * 获得用户远程地址
	 * 
	 * @param request
	 *            request对象
	 * @return 返回用户的远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (StringUtils.isBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 获取user-agent
	 * 
	 * @return 返回客户使用的机器名
	 */
	public static String getUserAgent() {
		return getRequest().getHeader("User-Agent");
	}

	/**
	 * 获取域名及项目根路径
	 * 
	 * @return 返回域名及项目根路径
	 */
	public static String getDomainAndProjectPath() {
		StringBuffer url = getRequest().getRequestURL();
		return url.delete(url.length() - getRequest().getRequestURI().length(), url.length())
				.append(getRequest().getServletContext().getContextPath()).append("/").toString()
				.replace("http://", httpProtocol + "://");

	}

	/**
	 * 将request对象转换成T对象
	 * 
	 * @param <T>
	 *            类的泛型
	 * @param clazz
	 *            类的类型eg:customer.class
	 * @return 返回类对象
	 */
	public static <T> T request2Bean(Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			Enumeration<String> e = getRequest().getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = getRequest().getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取来访者的浏览器版本
	 * 
	 * @return 返回浏览器版本
	 */
	public static String getRequestBrowserInfo() {
		String browserVersion = null;
		String header = getRequest().getHeader("user-agent");
		if (header == null || header.equals("")) {
			return "";
		}
		if (header.indexOf("MSIE") > 0) {
			browserVersion = "IE";
		} else if (header.indexOf("Firefox") > 0) {
			browserVersion = "Firefox";
		} else if (header.indexOf("Chrome") > 0) {
			browserVersion = "Chrome";
		} else if (header.indexOf("Safari") > 0) {
			browserVersion = "Safari";
		} else if (header.indexOf("Camino") > 0) {
			browserVersion = "Camino";
		} else if (header.indexOf("Konqueror") > 0) {
			browserVersion = "Konqueror";
		}
		return browserVersion;
	}

	/**
	 * 获取系统版本信息
	 * 
	 * @return 返回系统版本
	 */
	public static String getRequestSystemInfo() {
		String systenInfo = null;
		String header = getRequest().getHeader("user-agent");
		if (header == null || header.equals("")) {
			return "";
		}
		// 得到用户的操作系统
		if (header.indexOf("NT 6.0") > 0) {
			systenInfo = "Windows Vista/Server 2008";
		} else if (header.indexOf("NT 5.2") > 0) {
			systenInfo = "Windows Server 2003";
		} else if (header.indexOf("NT 5.1") > 0) {
			systenInfo = "Windows XP";
		} else if (header.indexOf("NT 6.0") > 0) {
			systenInfo = "Windows Vista";
		} else if (header.indexOf("NT 6.1") > 0) {
			systenInfo = "Windows 7";
		} else if (header.indexOf("NT 6.2") > 0) {
			systenInfo = "Windows Slate";
		} else if (header.indexOf("NT 6.3") > 0) {
			systenInfo = "Windows 9";
		} else if (header.indexOf("NT 5") > 0) {
			systenInfo = "Windows 2000";
		} else if (header.indexOf("NT 4") > 0) {
			systenInfo = "Windows NT4";
		} else if (header.indexOf("Me") > 0) {
			systenInfo = "Windows Me";
		} else if (header.indexOf("98") > 0) {
			systenInfo = "Windows 98";
		} else if (header.indexOf("95") > 0) {
			systenInfo = "Windows 95";
		} else if (header.indexOf("Mac") > 0) {
			systenInfo = "Mac";
		} else if (header.indexOf("Unix") > 0) {
			systenInfo = "UNIX";
		} else if (header.indexOf("Linux") > 0) {
			systenInfo = "Linux";
		} else if (header.indexOf("SunOS") > 0) {
			systenInfo = "SunOS";
		}
		return systenInfo;
	}

	/**
	 * 命令获取mac地址
	 * 
	 * @param cmd
	 * @return
	 */
	private static String callCmd(String[] cmd) {
		String result = "";
		String line = "";
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStreamReader is = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(is);
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param cmd
	 *            第一个命令
	 * @param another
	 *            第二个命令
	 * @return 第二个命令的执行结果
	 */
	private static String callCmd(String[] cmd, String[] another) {
		String result = "";
		String line = "";
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);
			proc.waitFor(); // 已经执行完第一个命令，准备执行第二个命令
			proc = rt.exec(another);
			InputStreamReader is = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(is);
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param ip
	 *            目标ip,一般在局域网内
	 * @param sourceString
	 *            命令处理的结果字符串
	 * @param macSeparator
	 *            mac分隔符号
	 * @return mac地址，用上面的分隔符号表示
	 * 
	 */
	private static String filterMacAddress(final String ip, final String sourceString, final String macSeparator) {
		String result = "";
		String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(sourceString);
		while (matcher.find()) {
			result = matcher.group(1);
			if (sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {
				break; // 如果有多个IP,只匹配本IP对应的Mac.
			}
		}
		return result;
	}

	/**
	 * @param ip
	 *            目标ip
	 * @return Mac Address
	 */
	private static String getMacInWindows(final String ip) {
		String result = "";
		String[] cmd = { "cmd", "/c", "ping " + ip };
		String[] another = { "cmd", "/c", "arp -a" };
		String cmdResult = callCmd(cmd, another);
		result = filterMacAddress(ip, cmdResult, "-");
		return result;
	}

	/**
	 * @param ip
	 *            目标ip
	 * @return Mac Address
	 */
	private static String getMacInLinux(final String ip) {
		String result = "";
		String[] cmd = { "/bin/sh", "-c", "ping " + ip + " -c 2 && arp -a" };
		String cmdResult = callCmd(cmd);
		result = filterMacAddress(ip, cmdResult, ":");
		return result;
	}

	/**
	 * 获取MAC地址
	 * 
	 * @return 返回MAC地址
	 */
	public static String getMacAddress() {
		String ip = getRemoteAddr();
		String macAddress = "";
		macAddress = getMacInWindows(ip).trim();
		if (macAddress == null || "".equals(macAddress)) {
			macAddress = getMacInLinux(ip).trim();
		}
		return macAddress;
	}

}
