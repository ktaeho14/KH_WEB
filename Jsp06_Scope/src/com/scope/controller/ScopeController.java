package com.scope.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ScopeController() {
        super();
        
    }

	//get방식으로넘어왔을때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("[controller]");
		
		String reqVal =(String)request.getAttribute("reqId");
		String sessionVal = (String)request.getSession().getAttribute("sessionId");
		String appVal = (String)getServletContext().getAttribute("appId");
		
		System.out.println("request: " + reqVal);
		System.out.println("sessionVal: " +sessionVal);
		System.out.println("appVal: " + appVal);
		
		
		request.setAttribute("reqId", "reqId in servlet");
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		dispatch.forward(request, response);
	}

	//post방식으로 넘어왔을떄
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
