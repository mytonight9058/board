package com.khrd.dto;

import java.util.Date;

public class Article {

	private int article_no;
	private String writer_id;
	private String writer_name;
	private String title;
	private Date regdate;
	private Date moddate;
	private int read_cut;
	private String content;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(int article_no, String writer_id, String writer_name, String title, Date regdate, Date moddate,
			int read_cut, String content) {
		super();
		this.article_no = article_no;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.read_cut = read_cut;
		this.content = content;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public int getRead_cut() {
		return read_cut;
	}
	public void setRead_cut(int read_cut) {
		this.read_cut = read_cut;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Article [article_no=" + article_no + ", writer_id=" + writer_id + ", writer_name=" + writer_name
				+ ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate + ", read_cut=" + read_cut
				+ ", content=" + content + "]";
	}
	
}
