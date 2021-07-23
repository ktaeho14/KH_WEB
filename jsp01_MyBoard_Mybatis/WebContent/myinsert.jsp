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
	<h1>글쓰기</h1>
	
	<%--action: 어디로 넘길거냐  method: 어떤방식으로 넘길거냐 post(url로 보이지않게 넘긴다) get방식은(url로 보인다) --%>
	<form action="myinsert_res.jsp" method="post">
		<table>
			<tr>
				<th>NAME: </th>
				<td><input type="text" name="myname"></td>
			</tr>
			
			<tr>
				<th>TITLE: </th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>CONTENT: </th>
				<td><textarea rows="10" cols="60" name="mycontent"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="입력">
				<input type="button" value="취소" onclick="location.href='mylist.jsp'">
				</td>
			</tr>
			
			
			
		</table>
	</form>
















</body>
</html>