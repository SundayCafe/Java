package com.kkk.controller;

import java.util.Date;
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
import com.kkk.entity.Admin;
import com.kkk.entity.Inform;
import com.kkk.entity.Student;

@Controller
public class AdminController  extends BaseController
{
	@RequestMapping({"/admin"})
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		if(null == user || !(user instanceof Admin))
		{
			mm.put("errorMsg", "禁止访问未授权页面！");
			return new ModelAndView("/login").addAllObjects(mm);
		}
		Admin admin = (Admin)user;
		mm.put("admin", admin);
		Map<String,String> paramMap = new HashMap<String,String>();
		List<Map<String,Object>> questionList = questionService.queryAllQuestion(paramMap);
		mm.put("questionList", questionList);		
		return new ModelAndView("admin/adminindex").addAllObjects(mm);
	}
	
	@RequestMapping({"addinform"})
	public ModelAndView addinform(HttpServletRequest request,ModelMap mm)
	{
		List<Map<String,Object>> infoList = adminService.queryInfoForm(new HashMap<String,String>());
		mm.put("infoList", infoList);
		return new ModelAndView("admin/addinform").addAllObjects(mm);
	}
	
	@RequestMapping({"doAddInForm"})
	public ModelAndView doAddInForm(String infoContext,HttpServletResponse response, HttpServletRequest request,ModelMap mm){
		Inform entity = new Inform();
		entity.setCreatetime(new Date(System.currentTimeMillis()));
		entity.setInfoContext(infoContext);
		adminService.addInfoForm(entity);
		return new ModelAndView("redirect:addinform.action");
	}
	
	@RequestMapping({"disposereport"})
	public ModelAndView disposereport(HttpServletRequest request,ModelMap mm)
	{
		List<Map<String,Object>> list = adminService.queryAllReportReply();
		mm.put("list", list);
		return new ModelAndView("admin/disposereport").addAllObjects(mm);
	}
	
	@RequestMapping({"deleteReply"})
	public ModelAndView deleteReply(int id,String userid,HttpServletRequest request){
		adminService.deleteReplyById(id);
		Student student = new Student();
		student.setStudentid(userid);
		student.setUnusedbegintime(new Date(System.currentTimeMillis()));
		studentService.update(student);//确实水贴的封号一周处理
		return new ModelAndView("redirect:disposereport.action");
	}
	
	/**
	 * 展示用户信息
	 * @param userType  用户类型，教师和学生（1和2）
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"userinfo"})
	public ModelAndView userinfo(String userType,HttpServletRequest request,ModelMap mm)
	{
		mm.put("studentList", adminService.queryAllStudent());
		mm.put("teacherList", adminService.queryAllTeahcer());
		return new ModelAndView("admin/userinfo").addAllObjects(mm);
	}
	
	/**
	 * 进入修改用户密码页面
	 * @param userType
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"toChangePwdPage"})
	public ModelAndView toChangePwdPage(String userType,int id,String password,HttpServletRequest request,ModelMap mm)
	{
		mm.put("usertype", userType);
		mm.put("password", password);
		mm.put("id", id + "");
		return new ModelAndView("admin/toChangePwdPage").addAllObjects(mm);
	}
	
	/**
	 * 更新用户密码
	 * @param userType
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"doChangePwd"})
	public ModelAndView doChangePwd(String userType,int id,String password,String newpassword,HttpServletRequest request,ModelMap mm)
	{
		if(newpassword.equals(password)){
			return new ModelAndView("redirect:userinfo.action");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("password", newpassword);
		paramMap.put("id", id);
		if(UserType.TEACHER.getValue().equals(userType))
		{
			paramMap.put("userType", 1);
		}else if(UserType.STUDENT.getValue().equals(userType))
		{
			paramMap.put("userType", 0);
		}else{
			
		}
		adminService.updatePwd(paramMap);
		return new ModelAndView("redirect:userinfo.action");
	}
	
}
