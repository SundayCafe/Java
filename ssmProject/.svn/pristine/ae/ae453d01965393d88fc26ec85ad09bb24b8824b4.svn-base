
package com.kkk.dao;

import java.util.List;
import java.util.Map;

import com.kkk.entity.Question;

public interface IQuestionDao
{

	int deleteByPrimaryKey(Integer id);

	int insert(Question record);

	int insertSelective(Question record);

	Question selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Question record);

	int updateByPrimaryKey(Question record);

	List<Map<String, Object>> queryAllQuestion(Map<String, String> paramMap);

	void add(Question question);

	Map<String, Object> getQuestionDetailById(Map<String, String> paramMap);

	List<Map<String, Object>> getReplyListByQuestionid(Map<String, String> paramMap);

	List<Map<String, Object>> queryMyQuestions(Map<String, String> paramMap);

	void updateQuestion(Map<String, String> paramMap);

	List<Map<String, Object>> searchQuestionsByKeyWords(Map<String, String> paramMap);
}