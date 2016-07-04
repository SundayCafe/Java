
package com.kkk.entity;

import java.util.Date;

public class Inform
{

	private int id;
	private String infoContext;
	private Date createtime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getInfoContext()
	{
		return infoContext;
	}

	public void setInfoContext(String infoContext)
	{
		this.infoContext = infoContext;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}
}
