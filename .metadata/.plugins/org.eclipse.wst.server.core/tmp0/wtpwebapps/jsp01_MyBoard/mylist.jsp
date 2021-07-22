<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--jsp파일을 만들면 습관처럼 작성할 부분 --%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<%--dao객체를 만들어주기 위해서 임포트를 해주는 작업 --%>
<%@ page import="com.my.dao.MyBoardDao" %>   
<%--dto객체를 사용하기 위해서 임포트를 해주는 작업 --%>
<%@ page import="com.my.dto.MyBoardDto" %> 
<%--Collection List를 사용하기 위해서 임포트를 해주는 작업 --%>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

	//dao 객체 생성 및 selectAll()메소드를 list변수안에 넣어주기
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectAll();
	
%>
	<h1>List PAGE</h1>
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
<%
	for(int i=0; i<list.size(); i++){
%>		
		<tr>
			<td><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
			<td><%=list.get(i).getMydate() %></td>
			<td><a href="myupdate.jsp?myno=<%=list.get(i).getMyno()%>">수정</a></td>
			<td><a href="mydelete.jsp?myno=<%=list.get(i).getMyno()%>">삭제</a></td>
		</tr>
<%	
	}
%>

	<tr>
		<td colspan="6" align="right">
			<button onclick="location.href='myinsert.jsp'">글쓰기</button>
	</tr>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>