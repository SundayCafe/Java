package com.kkk.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.kkk.entity.Student;

public interface IStudentDao {

	@Select("SELECT * FROM student_tab WHERE studentId=#{studentId}")
	public Student findStudentByStudentId(String studentId);

	@Select("SELECT * FROM student_tab WHERE studentId=#{stuid}")
	Student selectByPrimaryKey(Integer stuid);
	
	@Select("SELECT * FROM student_tab WHERE id=#{id}")
	Student selectByKey(Integer id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
	
	@Select("SELECT * from student_tab where studentName=#{studentName}")
	List<Student> queryAllStudentByName(String studentName);
	
	Student findStudentByIdPwd(Map<String,String> paramMap);
	
	void update(Student student);

}
