
package com.kkk.service;

import java.util.Map;

import com.kkk.entity.Reply;

public interface IReplyService
{

	void add(Reply reply);

	int queryUnReadNums(Map<String, String> parmMap);

	int queryUnDoNums(Map<String, String> parmMap);

	void updateReply(Map<String, String> parmMap);

	Reply queryReplyById(Integer id);
}
