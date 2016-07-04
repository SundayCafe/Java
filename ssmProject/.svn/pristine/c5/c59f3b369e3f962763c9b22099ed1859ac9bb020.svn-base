package com.kkk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.IReportDao;
import com.kkk.service.IReportService;

@Service("reportService")
public class ReportServiceImpl implements IReportService
{
	@Resource
	IReportDao reportDao;
	@Override
	public void addReport(int replyId)
	{
		reportDao.addReport(replyId);
	}
}
