/**
 * 
 */
package com.lrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrd.entity.DevUser;
import com.lrd.service.DevUserService;

/**
 * @author L
 *
 */
@Controller
public class DevUserController {

	@Autowired
	private DevUserService dus;
	
	@RequestMapping(value="/dev/login",method={RequestMethod.GET})
	public String toLogin(){
		return "jsp/devlogin";
	}
	@RequestMapping(value="/dev/dologin",method={RequestMethod.POST})
	public String login(DevUser user,HttpServletRequest request,HttpSession session){
		DevUser logined=dus.login(user);
		if (null != logined) {
			session.setAttribute("devUserSession", logined);
			return "jsp/developer/main";
		}
		request.setAttribute("error","用户名或密码错误！" );
		return "jsp/devlogin";
	}
	
	@RequestMapping(value="/dev/logout",method={RequestMethod.GET})
	public String logout(HttpSession session){
		if (null!=session.getAttribute("devUserSession")) {
			session.removeAttribute("devUserSession");
		}
		/*return "jsp/devlogin";*/
		return "redirect:/";
	}
}
