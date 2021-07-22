package com.prdto;

import java.util.Date;

public class PRDto {
	private int seq;
	private String title;
	private String name;
	private String phone;
	private Date regdate;
	public PRDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PRDto(int seq, String title, String name, String phone, Date regdate) {
		super();
		this.seq = seq;
		this.title = title;
		this.name = name;
		this.phone = phone;
		this.regdate = regdate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
