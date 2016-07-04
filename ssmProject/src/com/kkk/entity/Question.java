
package com.kkk.entity;

import java.util.Date;

public class Question
{

	private Integer id;
	private String quetitle;
	private String quedescript;
	private Date releasedate;
	private String questionTabcol;
	private Integer replyhit;
	private String keyword;
	private String userid;
	private String status;
	private String teacherid;
	private String bestreplyid;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getQuetitle()
	{
		return quetitle;
	}

	public void setQuetitle(String quetitle)
	{
		this.quetitle = quetitle == null ? null : quetitle.trim();
	}

	public String getQuedescript()
	{
		return quedescript;
	}

	public void setQuedescript(String quedescript)
	{
		this.quedescript = quedescript == null ? null : quedescript.trim();
	}

	public Date getReleasedate()
	{
		return releasedate;
	}

	public void setReleasedate(Date releasedate)
	{
		this.releasedate = releasedate;
	}

	public String getQuestionTabcol()
	{
		return questionTabcol;
	}

	public void setQuestionTabcol(String questionTabcol)
	{
		this.questionTabcol = questionTabcol == null ? null : questionTabcol.trim();
	}

	public Integer getReplyhit()
	{
		return replyhit;
	}

	public void setReplyhit(Integer replyhit)
	{
		this.replyhit = replyhit;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	
	public String getTeacherid()
	{
		return teacherid;
	}

	
	public void setTeacherid(String teacherid)
	{
		this.teacherid = teacherid;
	}

	
	public String getBestreplyid()
	{
		return bestreplyid;
	}

	
	public void setBestreplyid(String bestreplyid)
	{
		this.bestreplyid = bestreplyid;
	}
}