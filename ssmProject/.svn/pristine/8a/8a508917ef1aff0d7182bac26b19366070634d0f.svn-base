
package com.kkk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.IQuestionDao;
import com.kkk.entity.Question;
import com.kkk.service.IQuestionService;

@Service("questionService")
public class QuestionServiceImpl implements IQuestionService
{

	@Resource
	private IQuestionDao questionDao;

	@Override
	public List<Map<String, Object>> queryAllQuestion(Map<String, String> paramMap)
	{
		return questionDao.queryAllQuestion(paramMap);
	}

	@Override
	public void add(Question question)
	{
		questionDao.add(question);
	}

	@Override
	public Map<String, Object> getQuestionDetailById(Map<String, String> paramMap)
	{
		return questionDao.getQuestionDetailById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getReplyListByQuestionid(
			Map<String, String> paramMap)
	{
		return questionDao.getReplyListByQuestionid(paramMap);
	}

	@Override
	public List<Map<String, Object>> queryMyQuestions(Map<String, String> paramMap)
	{
		return questionDao.queryMyQuestions(paramMap);
	}

	@Override
	public void updateQuestion(Map<String, String> paramMap)
	{
		questionDao.updateQuestion(paramMap);
	}

	@Override
	public List<Map<String, Object>> searchQuestionsByKeyWords(
			Map<String, String> paramMap)
	{
		// TODO Auto-generated method stub
		return questionDao.searchQuestionsByKeyWords(paramMap);
	}
}
