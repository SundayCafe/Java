package com.kkk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.IStudentDao;
import com.kkk.entity.Student;
import com.kkk.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Resource
	private IStudentDao studentdao;

	@Override
	public Student getUserById(int id) {
		return this.studentdao.selectByPrimaryKey(id);
	}

	@Override
	public Student update(Student student)
	{
		// TODO Auto-generated method stub
		studentdao.update(student);
		if(null == student.getId())
		{
			return studentdao.findStudentByStudentId(student.getStudentid());
		}
		return this.studentdao.selectByKey(student.getId());
	}

}
