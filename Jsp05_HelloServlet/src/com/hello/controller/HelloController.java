package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String contextP;
	private String initP;
    
    public HelloController() {
        System.out.println("servlet 생성자!!");
        
    }
    
    @Override
    public void init(ServletConfig config) {
    	System.out.println("servlet init(생성!)");
    	
    	contextP = config.getServletContext().getInitParameter("url");
    	initP = config.getInitParameter("driver");
    	
    	System.out.println("context param: " + contextP);
    	System.out.println("init param: " + initP);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식!!");
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식!!");
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("파라미터: " + command);
		
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>HelloServlet</h1>");
		out.print("<a href='home.html'>돌아가기</a>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy(종료)!");
		System.out.println("끝!");
	}
	
	
	
	
	
	
	
	

}
