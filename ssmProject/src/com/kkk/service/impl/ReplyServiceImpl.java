package com.kkk.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkk.dao.IReplyDao;
import com.kkk.entity.Reply;
import com.kkk.service.IReplyService;

@Service("replyService")
public class ReplyServiceImpl implements IReplyService
{
	@Resource
	IReplyDao replyDao;

	@Override
	public void add(Reply reply)
	{
		replyDao.add(reply);
	}

	@Override
	public int queryUnReadNums(Map<String, String> parmMap)
	{
		return replyDao.queryUnReadNums(parmMap);
	}

	@Override
	public void updateReply(Map<String, String> parmMap)
	{
		// TODO Auto-generated method stub
		replyDao.updateReply(parmMap);
	}

	@Override
	public int queryUnDoNums(Map<String, String> parmMap)
	{
		// TODO Auto-generated method stub
		return replyDao.queryUnDoNums(parmMap);
	}


	@Override
	public Reply queryReplyById(Integer id) {
		// TODO Auto-generated method stub
		return replyDao.queryReplyById(id);
	}
}
