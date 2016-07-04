package com.kkk.service;

import java.util.List;
import java.util.Map;


public interface ILoginService {

	boolean exist(String name);

	Map<String, Object> getUser(String name, String password);

	String editPsd(String id, String oldPsd, String newPsd);
	
	Object getUserByIdPwd(String userId,String passWord,String userType);
	//首页显示公告
	List<Map<String,Object>> queryInfoFormOnlyOne(Map<String,String> paramMap);
	
}
