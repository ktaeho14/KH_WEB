package com.multi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.multi.dto.MDBoardDto;

import common.JDBCTemplate;

public class MDBoardDao extends JDBCTemplate{

	//게시판 목록
	public List<MDBoardDto> selectAll(){
		//Connection 객체
		Connection con = getConnection();
		//statement객체
		Statement stmt = null;
		//결과값을 담을
		ResultSet rs = null;
		//리스트에 담아줄 리스트
		List<MDBoardDto> res = new ArrayList<MDBoardDto>();
		
		String sql = "SELECT * FROM MDBOARD ORDER BY SEQ DESC";
		
		try {
			stmt = con.createStatement();
			System.out.println("03. query 준비: " + sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MDBoardDto tmp = new MDBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3)
												,rs.getString(4),rs.getDate(5));
				res.add(tmp);
				
			}
			
		} catch (SQLException e) {
			System.out.println("3/4단계 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05.db 종료\n");
		}
		
		return res;
	}
	
	//글 선택
	public MDBoardDto selectOne(int seq) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto res = null;
		
		String sql = "SELECT * FROM MDBOARD WHERE SEQ = ?";
		
		con = getConnection();
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비:sql");
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			
			if(rs.next()) {
				res = new MDBoardDto();
				res.setSeq(rs.getInt(1));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 실패");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		
		
		
		return res;
	}
	
	//글 작성
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. query준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	//글 수정
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res =0;
		
		String sql = "UPDATE MDBOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03. query 준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		return res;
	}
	
	//글 삭제
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		MDBoardDto dto = new MDBoardDto();
		
		String sql = "DELETE FROM MDBOARD WHERE SEQ=?";		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03. query준비:" + sql);
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 오류");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		return res;
	}
	
	
	public int MultiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int[] cnt = null;
		
		String sql = " DELETE FROM MDBOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			for(int i=0; i<seq.length; i++) {
				pstm.setString(1, seq[i]);
				
				//메모리에 적재 후 executeBatch로 한번에 실행
				pstm.addBatch();
				System.out.println("03. query 준비: " + sql + "(삭제할 번호: "+seq[i]+")");
			}
			//int[]로 리턴
			cnt= pstm.executeBatch();
			System.out.println("04. query 실행 및 리턴");
			//성공: -2
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i]==-2) {
					res++;
				}
			}
			
			if(seq.length==res) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 오류");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		
		return res;
	}
	
	
	
	
	
	
	
	
	
}
