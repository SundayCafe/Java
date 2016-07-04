package com.kkk.service;

import com.kkk.entity.Student;

public interface IStudentService {

	public Student getUserById(int id);
	
	public Student update(Student student);
}
