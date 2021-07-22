package com.prdao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prdto.PRDto;
public class PRDaoImpl implements PRDao{

	@Override
	public List<PRDto> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<PRDto> list = new ArrayList<PRDto>();
		
		try {
			pstm = con.prepareStatement(selectAllsql);
			System.out.println("03. sql 준비");
			rs = pstm.executeQuery();
			System.out.println("04. sql 실행 및 리턴");
			
			while(rs.next()) {
				PRDto tmp = new PRDto(rs.getInt(1),rs.getString(2),
									rs.getString(3),rs.getString(4),
									rs.getDate(5));
				list.add(tmp);
				
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		
		return list;
	}

	@Override
	public PRDto selectOne(Connection con, int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Connection con, PRDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Connection con, PRDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Connection con, int seq) {
		// TODO Auto-generated method stub
		return false;
	}

}
