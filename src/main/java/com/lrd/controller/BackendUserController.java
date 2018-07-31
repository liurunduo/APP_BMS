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

import com.lrd.dao.BackendUserDao;
import com.lrd.entity.BackendUser;
import com.lrd.service.BackendUserService;

/**
 * @author L
 *
 */
@Controller
public class BackendUserController {

	@Autowired
	private BackendUserService bus;
	
	@RequestMapping(value="/manager/login",method={RequestMethod.GET})
	public String tologin(){
		
		return "jsp/backendlogin";
	}
	
	@RequestMapping(value="/manager/dologin",method={RequestMethod.POST})
	public String login(BackendUser user,HttpServletRequest request,HttpSession session){
		BackendUser logined = bus.login(user);
		if (null != logined) {
			session.setAttribute("userSession", logined);
			return "jsp/backend/main";
		}
		request.setAttribute("error", "用户名或密码错误！");
		return "jsp/backendlogin";
			
	}
	
	@RequestMapping(value="/manager/logout",method={RequestMethod.GET})
	public String logout(HttpSession session){
		if (null!=session.getAttribute("userSession")) {
			session.removeAttribute("userSession");
		}
		/*return "jsp/backendlogin";*/
		return "redirect:/";
	}
}
