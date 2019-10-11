package com.khrd.dto;

public class Change {

	private String nowP;
	private String newP;
	public Change() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Change(String nowP, String newP) {
		super();
		this.nowP = nowP;
		this.newP = newP;
	}
	public String getNowP() {
		return nowP;
	}
	public void setNowP(String nowP) {
		this.nowP = nowP;
	}
	public String getNewP() {
		return newP;
	}
	public void setNewP(String newP) {
		this.newP = newP;
	}
	@Override
	public String toString() {
		return "Change [nowP=" + nowP + ", newP=" + newP + "]";
	}
	
	
	
}
