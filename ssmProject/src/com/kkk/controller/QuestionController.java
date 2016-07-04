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

import com.kkk.entity.Question;
import com.kkk.entity.Reply;
import com.kkk.entity.Student;
import com.kkk.entity.Teacher;
import com.mysql.jdbc.StringUtils;

@Controller	
public class QuestionController extends BaseController
{
	/**
	 * 教师查看未处理的问题
	 * @param response
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"myUnDoQuestion"})
	public ModelAndView myUnDoQuestion(HttpServletResponse response, HttpServletRequest request, ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		Teacher teacher = (Teacher)user;
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("teacherid", teacher.getTeacherid() + "_unread");
		List<Map<String,Object>> questionList = questionService.searchQuestionsByKeyWords(paramMap);
		mm.put("questionList", questionList);
		return new ModelAndView("teacher/teacherindex").addAllObjects(mm);
	}
	/**
	 * 关键字搜索问题
	 * @param keyWord
	 * @param response
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"searchQuestionByKeyWord"})
	public ModelAndView search(String keyWord, HttpServletResponse response, HttpServletRequest request, ModelMap mm)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("keyWord", "%" + keyWord + "%");
		List<Map<String,Object>> questionList = questionService.searchQuestionsByKeyWords(paramMap);
		mm.put("questionList", questionList);
		mm.put("keyWord", keyWord);
		Object user = request.getSession().getAttribute("loginUserInfo");
		if (user instanceof Student)
		{
			return new ModelAndView("student/studentindex").addAllObjects(mm);
		}else if(user instanceof Teacher)
		{
			return new ModelAndView("teacher/teacherindex").addAllObjects(mm);
		}
		return new ModelAndView("admin/adminindex").addAllObjects(mm);
	}
	/**
	 * 跳转到添加问题页面
	 * @param response
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"addQuestionPage"})
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		List<Map<String,Object>> teacherList = teacherService.findSomeTeachers(paramMap);
		mm.put("teacherList", teacherList);
		return new ModelAndView("student/addnewquestion").addAllObjects(mm);
	}
	/**
	 * 发起问题向教师求助
	 * @param question
	 * @param response
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"doAddQuestion"})
	public ModelAndView doAdd(Question question,HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		question.setReleasedate(new Date(System.currentTimeMillis()));
		Object user = request.getSession().getAttribute("loginUserInfo");
		Student student = (Student)user;
		question.setUserid(student.getStudentid());
		//添加问题时候会对老师提示
		if(!StringUtils.isNullOrEmpty(question.getTeacherid()))
		{
			question.setTeacherid(question.getTeacherid() + "_unread");
		}
		question.setKeyword(question.getQuetitle());
		questionService.add(question);
		Map<String,String> paramMap = new HashMap<String,String>();
		List<Map<String,Object>> teacherList = teacherService.findSomeTeachers(paramMap);
		mm.put("teacherList", teacherList);
		return new ModelAndView("student/addnewquestion").addAllObjects(mm);
	}
	/**
	 * 问题详情页面
	 * @param id
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"questionDetail"})
	public ModelAndView detail(String id,HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id", id);
		if(id.endsWith("_readed"))
		{
			paramMap.put("id", id.split("_")[0]);
			Object user = request.getSession().getAttribute("loginUserInfo");
			if (user instanceof Student)
			{
				Student student = (Student)user;
				paramMap.put("state", "2");
				paramMap.put("userid", student.getStudentid());
			}else if(user instanceof Teacher)
			{
				Teacher teacher = (Teacher)user;
				paramMap.put("userid", teacher.getTeacherid());
			}
			replyService.updateReply(paramMap);
		}
		Map<String,Object> question = questionService.getQuestionDetailById(paramMap);
		mm.put("question", question);
		List<Map<String,Object>> replyList = questionService.getReplyListByQuestionid(paramMap);
		mm.put("replyList", replyList);
		return new ModelAndView("questiondetails").addAllObjects(mm);
	}
	
	/**
	 * 进入我的提问页面
	 * @param request
	 * @param mm
	 * @return
	 */
	@RequestMapping({"myQuestionPage"})
	public ModelAndView myQuestionPage(String keyWord,HttpServletResponse response, HttpServletRequest request,ModelMap mm)
	{
		Object user = request.getSession().getAttribute("loginUserInfo");
		Student student = (Student)user;
		Map<String,String> paramMap = new HashMap<String,String>();
		if(!StringUtils.isNullOrEmpty(keyWord))
		{
			paramMap.put("keyWord", "%" + keyWord + "%");
		}
		paramMap.put("userid", student.getStudentid());
		List<Map<String,Object>> result = questionService.queryMyQuestions(paramMap);
		mm.put("myQuestionList", result);
		mm.put("keyWord", keyWord);
		return new ModelAndView("student/myquestionpage").addAllObjects(mm);
	}
	
	/**
	 * 关闭问题
	 */
	@RequestMapping({"closeQuestion"})
	public ModelAndView close(String id,HttpServletResponse response, HttpServletRequest request)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id", id);
		questionService.updateQuestion(paramMap);
		return new ModelAndView("redirect:myQuestionPage.action");
	}
	/**
	 * 给问题选择最优答案
	 * @param id
	 * @param replyid
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping({"setBestReplyForQuestion"})
	public ModelAndView update(String id,String replyid,HttpServletResponse response, HttpServletRequest request)
	{
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id", id);
		paramMap.put("status", "1");
		paramMap.put("bestreplyid", replyid);
		questionService.updateQuestion(paramMap);
		//被选中的回复作者奖励5分
		Reply reply = replyService.queryReplyById(Integer.parseInt((replyid)));
		Student student = studentService.getUserById(Integer.valueOf(reply.getUserid()));
		//非学生，不进行积分的奖励
		if(null != student){
			student.setGrade(student.getGrade() + 5);
			studentService.update(student);
		}
		return new ModelAndView("redirect:questionDetail.action?id=" + id);
	}
}
