package com.multi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.apache.ibatis.session.SqlSession;

import com.multi.dto.MDBoardDto;

import common.JDBCTemplate;

public class MDBoardDao_old extends SqlMapConfig{
	private String namespace = "com.my.multi.";
	
	
	
	//게시판 목록
	public List<MDBoardDto>  selectAll() {
		List<MDBoardDto> res = null;
		SqlSession session =null;
		
		try {
			session = getsqlSessionFactory().openSession(false);
			res = session.selectList(namespace+"selectAll");
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return res;
	}
	
	//글 선택
	public MDBoardDto selectOne(int seq) {
		
		
		
		
		return null;
	}
	
	//글 작성
	public int insert(MDBoardDto dto) {
		
		
		return 0;
	}
	
	//글 수정
	public int update(MDBoardDto dto) {
		
		return 0;
	}
	
	//글 삭제
	public int delete(int seq) {
		
		return 0;
	}
	
	
	public int MultiDelete(String[] seq) {
		
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
