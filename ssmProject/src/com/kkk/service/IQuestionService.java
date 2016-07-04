
package com.kkk.service;

import java.util.List;
import java.util.Map;

import com.kkk.entity.Question;

public interface IQuestionService
{

	List<Map<String, Object>> queryAllQuestion(Map<String, String> paramMap);

	void add(Question question);

	Map<String, Object> getQuestionDetailById(Map<String, String> paramMap);

	List<Map<String, Object>> getReplyListByQuestionid(Map<String, String> paramMap);
	
	List<Map<String, Object>> queryMyQuestions(Map<String, String> paramMap);
	void updateQuestion(Map<String,String> paramMap);
	
	List<Map<String, Object>> searchQuestionsByKeyWords(Map<String, String> paramMap);
}
