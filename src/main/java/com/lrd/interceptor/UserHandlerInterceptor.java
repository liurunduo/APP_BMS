/**
 * 
 */
package com.lrd.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lrd.entity.BackendUser;
import com.lrd.entity.DevUser;


/**
 * @author Administrator
 *
 */
public class UserHandlerInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		/*SmbmsUser user=(SmbmsUser) request.getSession().getAttribute("userSession");
		String url=request.getContextPath();
		if (null == user) {
			request.getSession().setAttribute("error", "请先登录您的账号！");
			response.sendRedirect("http://"+request.getHeader("Host")+request.getContextPath()+"/login.jsp");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}*/
		DevUser devUser=(DevUser) request.getSession().getAttribute("devUserSession");
		BackendUser backendUser=(BackendUser) request.getSession().getAttribute("userSession");
		String url=request.getRequestURI();
		
		if (null == devUser && null==backendUser || 
				null != devUser && null==backendUser && url.indexOf("/manager/")!=-1 || 
				null != backendUser && null==devUser && url.indexOf("/dev/")!=-1) {
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		return true;
	}


}
