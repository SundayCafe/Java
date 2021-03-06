package com.kkk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kkk.entity.Teacher;

@Controller
public class TeacherController  extends BaseController
{
	
	@RequestMapping({"/teacher"})
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		if(null == user || !(user instanceof Teacher))
		{
			mm.put("errorMsg", "禁止访问未授权页面！");
			return new ModelAndView("/login").addAllObjects(mm);
		}
		Teacher teacher = (Teacher)user;
		mm.put("teacher", teacher);
		Map<String,String> paramMap = new HashMap<String,String>();
		List<Map<String,Object>> questionList = questionService.queryAllQuestion(paramMap);
		mm.put("questionList", questionList);	
		return new ModelAndView("teacher/teacherindex").addAllObjects(mm);
	}
}
