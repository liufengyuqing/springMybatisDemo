/**
 * author 刘志伟
 * 2017-6-23
 */
package com.tedu.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author 刘志伟
 * 
 *         2017-6-23
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {

		// 判断session有没有保存登录的用户
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		if (username == null) {
			System.out.println("还没有登录，无法获取订单，被拦截 返回到登录页面");
			response.sendRedirect(request.getContextPath() + "/toLogin.do");
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
	 * Object arg2, ModelAndView arg3) throws Exception {
	 * System.out.println("ActionController执行后，还没将处理结果返回时执行"); }
	 * 
	 * public void afterCompletion(HttpServletRequest arg0,HttpServletResponse
	 * arg1, Object arg2, Exception arg3) throws Exception {
	 * System.out.println("ActionController执行后，将处理结果返回后执行"); }
	 */

}
