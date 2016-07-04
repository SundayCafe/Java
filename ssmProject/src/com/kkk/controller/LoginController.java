package com.kkk.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kkk.common.UserType;
import com.kkk.controller.info.LoginInfo;
import com.kkk.entity.Student;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping({"/"})
public class LoginController  extends BaseController{
	public static final SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping({"/index"})
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		List<Map<String,Object>> Lastinfo = loginSercice.queryInfoFormOnlyOne(new HashMap<String, String>());
		mm.put("infoList", Lastinfo);
		return new ModelAndView("/login");
	}
	
	
	@RequestMapping({"/login"})
	public ModelAndView login(LoginInfo loginInfo,HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		if(null == loginInfo || StringUtils.isNullOrEmpty(loginInfo.getUserType()))
		{
			mm.put("errorMsg", "请选择用户类型");
			return new ModelAndView("login").addAllObjects(mm);
		}
		if(StringUtils.isNullOrEmpty(loginInfo.getUserName()))
		{
			mm.put("errorMsg", "用户名不能为空！");
			return new ModelAndView("login").addAllObjects(mm);
		}
		if(StringUtils.isNullOrEmpty(loginInfo.getUserPwd()))
		{
			mm.put("errorMsg", "密码不能为空！");
			return new ModelAndView("login").addAllObjects(mm);
		}
		String userType = loginInfo.getUserType(); 
		Object userInfo = loginSercice.getUserByIdPwd(loginInfo.getUserName(), loginInfo.getUserPwd(), userType);
		request.getSession().setAttribute("loginUserInfo", userInfo);
		if(userType.equals(UserType.ADMIN.getValue()))
		{
			return new ModelAndView("redirect:admin.action");
		}else if(userType.equals(UserType.TEACHER.getValue()))
		{
			return new ModelAndView("redirect:teacher.action");
		}else if(userType.equals(UserType.STUDENT.getValue()))
		{
			Student student = (Student)userInfo;
			if(null != student.getUnusedbegintime())
			{
				long unusedbegintime = student.getUnusedbegintime().getTime();
				long nowtime = System.currentTimeMillis();
				if(nowtime < (unusedbegintime + 7 * 24 * 60 * 60 * 1000)){//说明还没过封号期限
					mm.put("errorMsg", "您的账户被管理员于" + DATE_FORMAT.format(student.getUnusedbegintime()) + "封号，请于封号一周后再尝试登录！");
					request.getSession().removeAttribute("loginUserInfo");
					return new ModelAndView("/login").addAllObjects(mm);
				}
			}
			return new ModelAndView("redirect:student.action");
		}else{
			mm.put("errorMsg", "未授权访问的页面!");
			request.getSession().removeAttribute("loginUserInfo");
			return new ModelAndView("/login").addAllObjects(mm);
		}
	}
	
	@RequestMapping({"logout"})
	public ModelAndView logout(HttpServletResponse response, HttpServletRequest request)
	{
		request.getSession().removeAttribute("loginUserInfo");
		return new ModelAndView("redirect:index.action");
	}
}
