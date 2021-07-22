<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목격 게시판</h1>
	
	<table border="1">
		<col width="100"> <col width="100"><col width="300"><col width="200">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">----작성된 게시글이 없습니다----</td>
				</tr>
			</c:when>
		<c:otherwise>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.seq }</td>
					<td>${dto.title }</td>
					<td>${dto.name }</td>
					<td>${dto.regdate }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
		
		</c:choose>
		
		<tr>
			<td colspan="4"><input type="button" value="글쓰기"></td>
		</tr>
		
		
		
		
		
	
	</table>
</body>
</html>