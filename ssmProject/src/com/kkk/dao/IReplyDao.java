package com.kkk.dao;

import java.util.Map;

import com.kkk.entity.Reply;

public interface IReplyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
    
    void add(Reply reply);
    
    int queryUnReadNums(Map<String,String> parmMap);
    
    void updateReply(Map<String,String> parmMap);
    int queryUnDoNums(Map<String, String> parmMap);
    
    Reply queryReplyById(Integer id);
}