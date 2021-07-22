package com.prcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prbiz.PRBiz;
import com.prbiz.PRBizImpl;
import com.prdto.PRDto;

import sun.rmi.server.Dispatcher;


@WebServlet("/PRController")
public class PRController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PRController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		if(command.equals("list")) {
			PRBiz biz = new PRBizImpl();
			List<PRDto> list = biz.selectAll();
			
			request.setAttribute("list", list);
			dispatch("boardlist.jsp", request, response);
		}
		
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
