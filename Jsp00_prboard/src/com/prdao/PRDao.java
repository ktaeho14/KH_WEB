package com.prdao;

import java.sql.Connection;
import java.util.List;

import com.prdto.PRDto;

public interface PRDao {
	
	String selectAllsql = "SELECT * FROM PRBOARD ORDER BY SEQ DESC";
	
	public List<PRDto> selectAll(Connection con);
	public PRDto selectOne(Connection con, int seq);
	public boolean insert(Connection con, PRDto dto);
	public boolean update(Connection con, PRDto dto);
	public boolean delete(Connection con, int seq);
	
}
