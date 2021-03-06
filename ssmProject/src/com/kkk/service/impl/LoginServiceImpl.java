package com.kkk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.common.UserType;
import com.kkk.dao.IAdminDao;
import com.kkk.dao.IStudentDao;
import com.kkk.dao.ITeacherDao;
import com.kkk.entity.Admin;
import com.kkk.entity.Student;
import com.kkk.entity.Teacher;
import com.kkk.service.ILoginService;

@Service("loginSercice")
public class LoginServiceImpl implements ILoginService {

	@Resource
	private IStudentDao studentDao;
	@Resource
	private IAdminDao adminDao;
	@Resource
	private ITeacherDao teacherDao;

	@Override
	public boolean exist(String name) {
		boolean result = false;
		List<Student> studentList = studentDao.queryAllStudentByName(name);
		result = null != studentList && !studentList.isEmpty();
		List<Admin> adminList = adminDao.queryAllAdminByName(name);
		result = null != adminList && !adminList.isEmpty();
		List<Teacher> teacherList = teacherDao.queryAllTeacherByName(name);
		result = null != teacherList && !teacherList.isEmpty();
		return result;
	}

	@Override
	public Map<String, Object> getUser(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editPsd(String id, String oldPsd, String newPsd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserByIdPwd(String userId, String passWord, String userType) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("passWord", passWord);
		if (UserType.ADMIN.getValue().equals(userType)) {
			return adminDao.findAdminByIdPwd(paramMap);
		} else if (UserType.TEACHER.getValue().equals(userType)) {
			return teacherDao.findTeacherByIdPwd(paramMap);
		} else if (UserType.STUDENT.getValue().equals(userType)) {
			return studentDao.findStudentByIdPwd(paramMap);
		} else {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> queryInfoFormOnlyOne(
			Map<String, String> paramMap) {
		return adminDao.queryInfoFormOnlyone(paramMap);
	}

	
}