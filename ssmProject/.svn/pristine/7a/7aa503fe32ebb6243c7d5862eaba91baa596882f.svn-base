package com.kkk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.ITeacherDao;
import com.kkk.service.ITeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService
{
	@Resource
	ITeacherDao teacherDao;

	@Override
	public List<Map<String, Object>> findSomeTeachers(Map<String, String> paramMap)
	{
		return teacherDao.findSomeTeachers(paramMap);
	}
}
