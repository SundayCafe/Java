package com.kkk.service;

import java.util.List;
import java.util.Map;

import com.kkk.entity.Inform;

public interface IAdminService
{
	void addInfoForm(Inform entity);
	List<Map<String,Object>> queryInfoForm(Map<String,String> paramMap);
	
	List<Map<String,Object>> queryAllReportReply();
	void deleteReplyById(int id);
	void updatePwd(Map<String,Object> paramMap);
	List<Map<String,Object>> queryAllStudent();
	List<Map<String,Object>> queryAllTeahcer();
}
