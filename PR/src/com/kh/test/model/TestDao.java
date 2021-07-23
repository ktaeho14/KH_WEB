package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
	
	public List<Test> selectList(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. 드라이버 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("01. 드라이버 연결 실패");
			e.printStackTrace();
		}
		
		String DbUrl = "jdbc:oracle:thin:@192.168.10.3:1521:xe";
		String DbUsername = "kh";
		String DbPassword = "kh";
		
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Test> res = new ArrayList<Test>();
		String sql = "SELECT * FROM TEST";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(DbUrl,DbUsername,DbPassword);
			
			
			pstm = con.prepareStatement(sql);
			System.out.println("03.query 준비: " + sql);
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			
			while(rs.next()) {
				Test tmp = new Test();
				
				tmp.setSeq(rs.getInt(1));
				tmp.setWriter(rs.getString(2));
				tmp.setTitle(rs.getString(3));
				tmp.setContent(rs.getString(4));
				tmp.setRegdate(rs.getDate(5));
				
				res.add(tmp);
			}
			
			
		} catch (SQLException e) {
			System.out.println("02.계정연결 실패");
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
				System.out.println("05.db종료");
			} catch (SQLException e) {
				System.out.println("05.db종료 실패");
				e.printStackTrace();
			}
		}
		
		
		return res;
	}
}