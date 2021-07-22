package com.prbiz;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.prdao.PRDao;
import com.prdao.PRDaoImpl;
import com.prdto.PRDto;
import static common.JDBCTemplate.*;
public class PRBizImpl implements PRBiz{

	@Override
	public List<PRDto> selectAll() {
			PRDao dao = new PRDaoImpl();
			Connection con = getConnection();
			List<PRDto> list = dao.selectAll(con);
			
			close(con);
		return list;
	}

	@Override
	public PRDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PRDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PRDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

}
