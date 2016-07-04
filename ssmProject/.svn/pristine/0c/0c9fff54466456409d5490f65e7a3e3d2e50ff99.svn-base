package com.kkk.test;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kkk.entity.Student;
import com.kkk.service.IStudentService;

public class TestStudent {

	private static Logger logger = Logger.getLogger(TestStudent.class);
	private ApplicationContext ac;
	@Resource
	private IStudentService StudentService;
	
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testfindById() {
		logger.info("ͨ通过id查找！");
		StudentService = (IStudentService)ac.getBean("StudentService");
		Student st = StudentService.getUserById(1);
		System.out.println(st);
	}
	
}
