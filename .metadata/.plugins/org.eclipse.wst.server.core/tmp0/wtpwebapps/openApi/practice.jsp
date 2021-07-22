<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/practice.js"></script>
</head>
<body>
	<form action="controller.do?command=practice_db" method="post">
	<input type="submit" value="db에 저장하기">
	
	
	
	<table>
		<thead></thead>
		<tbody></tbody>
	</table>
	</form>
</body>
</html>