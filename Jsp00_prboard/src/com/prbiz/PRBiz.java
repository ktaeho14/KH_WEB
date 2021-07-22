package com.prbiz;

import java.util.List;

import com.prdto.PRDto;

public interface PRBiz {
	public List<PRDto> selectAll();
	public PRDto selectOne(int seq);
	public boolean insert(PRDto dto);
	public boolean update(PRDto dto);
	public boolean delete(int seq);
}
