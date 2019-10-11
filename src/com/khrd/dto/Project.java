package com.khrd.dto;

import java.util.Date;

public class Project {

	private int no;
	private String name;
	private String content;
	private String Sdate;
	private String Ldate;
	private String proceeding;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Project [no=" + no + ", name=" + name + ", content=" + content + ", Sdate=" + Sdate + ", Ldate=" + Ldate
				+ ", proceeding=" + proceeding + "]";
	}
	public Project(int no, String name, String content, String sdate, String ldate, String proceeding) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		Sdate = sdate;
		Ldate = ldate;
		this.proceeding = proceeding;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSdate() {
		return Sdate;
	}
	public void setSdate(String sdate) {
		Sdate = sdate;
	}
	public String getLdate() {
		return Ldate;
	}
	public void setLdate(String ldate) {
		Ldate = ldate;
	}
	public String getProceeding() {
		return proceeding;
	}
	public void setProceeding(String proceeding) {
		this.proceeding = proceeding;
	}
	

}
