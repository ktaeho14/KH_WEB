<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX</h1>
	<%--forward 액션 태그는 jsp에서만 제공 되는 기능이다.
		제어권이 넘어갔다! --%>
	 <jsp:forward page="./mylist.jsp"></jsp:forward>
</body>
</html>