
package com.kkk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kkk.service.IAdminService;
import com.kkk.service.ILoginService;
import com.kkk.service.IQuestionService;
import com.kkk.service.IReplyService;
import com.kkk.service.IReportService;
import com.kkk.service.IStudentService;
import com.kkk.service.ITeacherService;

/**
 *	service库
 */
@Controller
public class BaseController
{

	@Autowired
	IQuestionService questionService;
	@Autowired
	ITeacherService teacherService;
	@Autowired
	IReplyService replyService;
	@Autowired
	IStudentService studentService;
	@Autowired
	IAdminService adminService;
	@Autowired
	ILoginService loginSercice;
	@Autowired
	IReportService reportService;
}
