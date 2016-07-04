
package com.kkk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController extends BaseController
{

	@RequestMapping({ "addReport" })
	public ModelAndView addReport(String replyId, HttpServletResponse response, HttpServletRequest request)
	{
		reportService.addReport(Integer.valueOf(replyId));
		return new ModelAndView("redirect:student.action");
	}
}
