
package com.kkk.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kkk.common.UserType;
import com.kkk.entity.Admin;
import com.kkk.entity.Student;
import com.kkk.entity.Teacher;

/**
 * 登录拦截器
 * 
 * @author Rui.kx
 */
public class CommonInterceptor extends HandlerInterceptorAdapter
{

	public static final String LAST_PAGE = "com.alibaba.lastPage";

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,HttpServletResponse httpservletresponse, Object obj, Exception exception)throws Exception
	{
		
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,HttpServletResponse httpservletresponse, Object obj,ModelAndView modelandview) throws Exception
	{
		//获取用户信息，并且判断用户类型
		Object user = httpservletrequest.getSession().getAttribute("loginUserInfo");
		ModelMap mm = new ModelMap();
		if(user instanceof Student){
			mm.put("userType", UserType.STUDENT.getValue());
		}else if(user instanceof Teacher){
			mm.put("userType", UserType.TEACHER.getValue());
		}else if(user instanceof Admin){
			mm.put("userType", UserType.ADMIN.getValue());
		}else{
			mm.put("userType", "");
		}
		modelandview.addAllObjects(mm);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception
	{
//		String requestUri = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String url = requestUri.substring(contextPath.length());
		//获取当前用户信息，判断当前用户是否有效
		Object user = request.getSession().getAttribute("loginUserInfo");
		if (user == null || "".equals(user.toString()))
		{
//			会话时效-跳转登录页面
			response.sendRedirect("index.action");
			return false;
		}
		else
		{
			return true;
		}
	}
}
