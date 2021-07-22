package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.MVCBoardDao;
import com.mvc.dto.MVCBoardDto;

/**
 * Servlet implementation class controller
 */
@WebServlet("/mycontroller.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MVCBoardDao dao = new MVCBoardDao();
		String command = request.getParameter("command");
		
		if(command.equals("boardlist")) {
			
			List<MVCBoardDto> list =  dao.selectAll();
		}else if(command.equals("boarddetail")) {
			int seq = Integer.parseInt(request.getParameter("animal_no"));
			MVCBoardDto dto = new MVCBoardDto();
			
			dto = dao.selectOne(seq);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
