package com.kkk.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kkk.entity.Admin;
import com.kkk.entity.Reply;
import com.kkk.entity.Student;
import com.kkk.entity.Teacher;
import com.mysql.jdbc.StringUtils;

@Controller
public class ReplyController extends BaseController
{
	/**
	 * 回答问题
	 * @param reply
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"addReply"})
	public ModelAndView addReply(Reply reply,HttpServletRequest request,HttpServletResponse response,ModelMap mm)
	{
		if(StringUtils.isNullOrEmpty(reply.getRepcontent()))
		{
			return new ModelAndView("redirect:questionDetail.action?id=" + reply.getQuestionid() + "&errorMsg = error");
		}
		Object user = request.getSession().getAttribute("loginUserInfo");
		if(user instanceof Student){
			Student student = (Student)user;
			reply.setUserid(student.getStudentid());
			//回复超过10个字。积1分
			if(reply.getRepcontent().length() >= 10){
				student.setGrade(student.getGrade() + 1);
			}
			student = studentService.update(student);//更新积分
			request.getSession().setAttribute("loginUserInfo", student);//更新会话中的账户信息
		}else if(user instanceof Teacher){
			Teacher teacher = (Teacher)user;
			reply.setUserid(teacher.getTeacherid());
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("id", reply.getQuestionid() + "");
			paramMap.put("status", "1");
			paramMap.put("teacherid", teacher.getTeacherid() + "_read");
			questionService.updateQuestion(paramMap);
		}else{
			Admin admin  = (Admin)user;
			reply.setUserid(admin.getAdminid());
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("id", reply.getQuestionid() + "");
			paramMap.put("status", "1");
			questionService.updateQuestion(paramMap);
		}
		reply.setRepdatetime(new Date(System.currentTimeMillis()));
		reply.setState("1");
		replyService.add(reply);
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id", reply.getQuestionid() + "");
		paramMap.put("status", "1");
		paramMap.put("replyHit", "1");
		questionService.updateQuestion(paramMap);
		return new ModelAndView("redirect:questionDetail.action?id=" + reply.getQuestionid());
	}
}
