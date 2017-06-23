/**
 * author 刘志伟
 * 2017-6-23
 */
package com.tedu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘志伟
 * 
 *         2017-6-23
 */
@Controller
public class ActionController {
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/toOrder.do")
	public String toOreder() {
		return "order";
	}

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, String username, String pwd) {
		System.out.println(username+pwd);
		if (username.equalsIgnoreCase("zs")&&pwd.equals("123")) {
			System.out.println("完成验证");
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			return "forward:toOrder.do";
		} else {
			return "forward:toLogin.do";
		}

	}

}
