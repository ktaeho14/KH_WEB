package com.multi.dto;
//데이터를 담아서 다른 곳으로 이동시킬 수 있는 클래스이다. Dto
import java.util.Date;

public class MDBoardDto {

	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	//생성자(기본, 매개변수) getter & setter
	
	public MDBoardDto() {
		super();
		
	}

	public MDBoardDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
