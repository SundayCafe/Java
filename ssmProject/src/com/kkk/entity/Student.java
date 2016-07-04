package com.kkk.entity;

import java.util.Date;

public class Student {
    private Integer id;

    private String studentid;

    private String studentname;

    private String password;

    private Integer grade;

    private String studentTabcol;
    
    private Date unusedbegintime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getStudentTabcol() {
        return studentTabcol;
    }

    public void setStudentTabcol(String studentTabcol) {
        this.studentTabcol = studentTabcol == null ? null : studentTabcol.trim();
    }

	
	public Date getUnusedbegintime()
	{
		return unusedbegintime;
	}

	
	public void setUnusedbegintime(Date unusedbegintime)
	{
		this.unusedbegintime = unusedbegintime;
	}
    
}