package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

//Dao는 DB와 연결을 하는 역할을 수행 한다. (JDBC)
public class MyBoardDao {
	
	//커넥션 준비
	Connection con = null;
	
	//드라이버 등록 및 연결
	public MyBoardDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01.driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("01.driver 연결 실패");
			e.printStackTrace();
		}
	}
	
	//전체출력
	public List<MyBoardDto> selectAll(){
		
		//커넥션 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02.계정 연결");
		} catch (SQLException e) {
			System.out.println("02.계정 연결 실패");
			e.printStackTrace();
		}
		
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MYBOARD";
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		try {
			
			//connection 을이용해 statement객체를 준비해주고
			stmt = con.createStatement();
			System.out.println("03.query 준비: " + sql);
			
			//executeuery(쿼리문)을 사용하여 rs에 담아주었다
			rs = stmt.executeQuery(sql);
			System.out.println("04.query 실행 및 리턴");
			
			//반복문 & next(한칸씩 이동) 시키며 있으면 true 없으면 false를 리턴 시켜 dto에 담자
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(rs.getInt(1),rs.getString(2),
												rs.getString(3),rs.getString(4),
												rs.getDate(5));
				
				//만들어둔 Collection List = res안에 add를 이용하여 담아주자
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			try {
				//사용한 자원들을 닫아준다(열어 주었던 역순으로)
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05.db 종료");
			} catch (SQLException e) {
				System.out.println("05.db 종료 에러");
				e.printStackTrace();
			}
		}
		
		
		
		
		return res;
	}
	
	//선택출력
	public MyBoardDto selectOne(int myno) {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm=null;
		ResultSet rs =null;
		String sql = "SELECT * FROM MYBOARD WHERE MYNO = ?";
		MyBoardDto res = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03. query 준비: sql");
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			if(rs.next()) {
				res = new MyBoardDto();
				res.setMyno(rs.getInt(1));
				res.setMyname(rs.getString(2));
				res.setMytitle(rs.getString(3));
				res.setMycontent(rs.getString(4));
				res.setMydate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 오류");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
				System.out.println("05. db종료\n");
			} catch (SQLException e) {
				System.out.println("05. db종료 오류");
				e.printStackTrace();
			}
			
		}
		
		
		return res;
	}
	
	
	//추가
	public int insert(MyBoardDto dto) {
		
		try {
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("03. query 준비:");
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05.db 종료\n");
				
			} catch (SQLException e) {
				System.out.println("05.db 종료 오류");
				e.printStackTrace();
			}
			
		}
		
		
		
		return res;
	}
	
	//수정
	public int update(MyBoardDto dto) {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql ="UPDATE MYBOARD SET MYTITLE=?,MYCONTENT=? WHERE MYNO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			System.out.println("03. query 준비 + sql");
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05. db 종료\n");
			} catch (SQLException e) {
				System.out.println("05. db 종료 오류");
				e.printStackTrace();
			}
			
		}
		return res;
	}
	
	//삭제
	public int delete(int myno) {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","KH","KH");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "DELETE FROM MYBOARD WHERE MYNO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03. query 준비: "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05. db 종료");
			} catch (SQLException e) {
				System.out.println("05. db 종료 오류");
				e.printStackTrace();
			}
			
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
}
