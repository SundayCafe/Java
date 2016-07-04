package com.kkk.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.kkk.entity.Admin;
import com.kkk.entity.Inform;

public interface IAdminDao {

	int deleteByPrimaryKey(Integer id);

	int insert(Admin record);

	int insertSelective(Admin record);

	@Select("SELECT * FROM admin_tab WHERE adminId=#{adminId}")
	Admin selectByPrimaryAdminId(String adminId);

	Admin selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
	
	@Select("select * from admin_tab where adminId=#{name}")
	List<Admin> queryAllAdminByName(String name);
	
	Admin findAdminByIdPwd(Map<String,String> paramMap);
	
	void addInfoForm(Inform entity);
	List<Map<String,Object>> queryInfoForm(Map<String,String> paramMap);
	
	List<Map<String,Object>> queryAllReportReply();
	void deleteReplyById(int id);
	
	void updatePwd(Map<String,Object> paramMap);
	
	List<Map<String,Object>> queryAllStudent();
	List<Map<String,Object>> queryAllTeahcer();
	
	@Select("select * from inform_tab where id=(SELECT MAX(id) from inform_tab)")
	List<Map<String,Object>> queryInfoFormOnlyone(Map<String,String> paramMap);
	
}