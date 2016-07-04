
package com.kkk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.IAdminDao;
import com.kkk.entity.Inform;
import com.kkk.service.IAdminService;

@Service("adminService")
public class IAdminServiceImpl implements IAdminService
{

	@Resource
	IAdminDao adminDao;

	@Override
	public void addInfoForm(Inform entity)
	{
		adminDao.addInfoForm(entity);
	}

	@Override
	public List<Map<String, Object>> queryInfoForm(Map<String, String> paramMap)
	{
		return adminDao.queryInfoForm(paramMap);
	}

	@Override
	public List<Map<String, Object>> queryAllReportReply()
	{
		return adminDao.queryAllReportReply();
	}

	@Override
	public void deleteReplyById(int id)
	{
		adminDao.deleteReplyById(id);
	}

	@Override
	public void updatePwd(Map<String, Object> paramMap)
	{
		adminDao.updatePwd(paramMap);
	}

	@Override
	public List<Map<String, Object>> queryAllStudent()
	{
		return adminDao.queryAllStudent();
	}

	@Override
	public List<Map<String, Object>> queryAllTeahcer()
	{
		return adminDao.queryAllTeahcer();
	}
	
	
}
