package com.lh.site.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lh.site.constant.Constant;
import com.lh.site.entity.StudentInfo;
import com.lh.site.utils.ServletUtils;

/**
 * 登录拦截器，必须登录后才能访问
 * @author zengxiaohui
 * @date 2017年9月5日 下午1:41:09
 * @version 1.0
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String domainAndProjectPath = ServletUtils.getDomainAndProjectPath();

		StudentInfo studentInfo = (StudentInfo) ServletUtils.getSessionAttribute(Constant.STUDENTINFO);
		if (studentInfo == null) {
			// 如果是ajax请求响应头会有，x-requested-with
			if (request.getHeader("x-requested-with") != null
					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
				response.setHeader("sessionStatus", "timeout");// 在响应头设置session状态
			} else {
				String url = request.getRequestURL().toString();
				String queryString = request.getQueryString();
				if (queryString != null && !"".equals(queryString)) {
					url = url + "?" + queryString;
				}
				ServletUtils.setSessionAttribute(Constant.REQ_URL, url);
				response.sendRedirect(domainAndProjectPath + "passport/login?urlactive=login");
			}
			return false;
		} else {
			return true;
		}
	}
}