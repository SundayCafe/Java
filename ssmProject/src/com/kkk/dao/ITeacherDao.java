package com.kkk.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.kkk.entity.Teacher;

public interface ITeacherDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    @Select("select * from teacher_tab where teacherName=#{name}")
    List<Teacher> queryAllTeacherByName(String name);
    
    Teacher findTeacherByIdPwd(Map<String,String> paramMap);
    
    List<Map<String,Object>> findSomeTeachers(Map<String,String>paramMap);
}