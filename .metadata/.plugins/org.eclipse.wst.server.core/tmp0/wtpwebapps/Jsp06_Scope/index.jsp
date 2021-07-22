<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/*
	4가지 scope 
	page : 현재 jsp페이지 내 영역 ex) pageContext
	request : 공유를 받아 넘어가는 영역까지 ex) request.getParameter
	session : 같은 브라우저의 내 영역까지 ex)session.setAttribute("");
	application : 하나의 어플리케이션당 하나의 어플리케이션이 생성이된다
					(공유객체)
*/



	pageContext.setAttribute("pageId", "mypageIdVal");
	request.setAttribute("reqId", "myRequestIdVal");
	session.setAttribute("sessionId", "mySessionIdVal");
	application.setAttribute("appId", "myApplicationIdVal");
%>

	<h1>index</h1>

	pageId: <%=pageContext.getAttribute("pageId") %> <br>
	reqId: <%=request.getAttribute("reqId") %>	<br>
	sessionId: <%=session.getAttribute("sessionId") %> <br>
	applicationId: <%=application.getAttribute("appId") %> <br>
	
	<a href="result.jsp">이동(result.jsp)</a>
	
	<a href="myservlet.do">이동(controller)</a>







</body>
</html>