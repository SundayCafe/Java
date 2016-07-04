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

import com.kkk.entity.Student;
import com.kkk.entity.Teacher;

@Controller
public class StudentController  extends BaseController{
	
	@RequestMapping({"grade"})
	public ModelAndView grade(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		Student student = (Student)user;
		student = studentService.getUserById(Integer.parseInt(student.getStudentid()));
		mm.put("student", student);
		return new ModelAndView("student/mygrade").addAllObjects(mm);
	}

	@RequestMapping({"/student"})
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		List<Map<String,Object>> questionList = questionService.queryAllQuestion(paramMap);
		mm.put("questionList", questionList);		
		return new ModelAndView("student/studentindex").addAllObjects(mm);
	}
	
	@RequestMapping({"/top"})
	public ModelAndView top(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		if(user instanceof Student)
		{
			Student student = (Student)user;
			student = studentService.getUserById(Integer.parseInt(student.getStudentid()));
			mm.put("student", student);
			request.getSession().setAttribute("loginUserInfo", student);
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("userid", student.getStudentid());
			int unReadNums = replyService.queryUnReadNums(paramMap);
			mm.put("unReadNums", unReadNums);
			return new ModelAndView("student/top").addAllObjects(mm);
		}else if(user instanceof Teacher){
			Teacher teacher = (Teacher)user;
			mm.put("teacher", teacher);
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("teacherid", teacher.getTeacherid() + "_unread");
			int unReadNums = replyService.queryUnDoNums(paramMap);
			mm.put("unReadNums", unReadNums);
			return new ModelAndView("teacher/top").addAllObjects(mm);
		}else{
			mm.put("admin", user);
			return new ModelAndView("admin/top").addAllObjects(mm);
		}
	}
	
}
