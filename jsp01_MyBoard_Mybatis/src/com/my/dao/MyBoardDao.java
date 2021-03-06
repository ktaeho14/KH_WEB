package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.my.dto.MyBoardDto;


public class MyBoardDao extends SqlMapConfig {
	private String namespace ="com.my.myboard.";
	
	
	//전체출력
	public List<MyBoardDto> selectAll(){
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		SqlSession session = null;
		//import org.apache.ibatis.session.SqlSession;
		
		//session 만들기!
		session = getSqlSessionFactory().openSession(true);
		
		//해당하는 namespace를 가진 mapper파일의 selectAll이라는 id를 가진것을 실행하겠다.
		//List에 담겨서 리턴을 해주었다!
		res = session.selectList("com.my.myboard.selectAll");
		
		session.close();
		
		return res;
	}
	
	//선택출력
	public MyBoardDto selectOne(int myno) {
		SqlSession session = null;
		MyBoardDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		
		res = session.selectOne(namespace+"selectOne",myno);
		
		session.close();
		return res;
	}
	
	
	//추가
	public int insert (MyBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try{
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"myinsert",dto);
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//수정
	public int update(MyBoardDto dto) {
		
		return 0;
	}
	
	//삭제
	public int delete(int myno) {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
