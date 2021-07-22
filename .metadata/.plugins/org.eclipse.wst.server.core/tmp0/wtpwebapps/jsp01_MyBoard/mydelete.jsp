<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.my.dao.MyBoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//parameter로 넘어오는 myno를 정수형으로 변환
	int myno = Integer.parseInt(request.getParameter("myno"));

	//일을 시키기위해 dao객체 생성
	MyBoardDao dao = new MyBoardDao();
	//res에 dao.delete(myno<<게시글번호 매개변수로넘기기)의 결과값(return값)을 담는다
	int res = dao.delete(myno);
	
	if(res>0){
%>
	<script type="text/javascript">
	alert("글 삭제 성공");
	location.href="mylist.jsp";
	</script>
<% 		
%>
	<script type="text/javascript">
	alert("글 삭제 실패");
	location.href="mylist.jsp";
	</script>
<%
	}
%>


</body>
</html>