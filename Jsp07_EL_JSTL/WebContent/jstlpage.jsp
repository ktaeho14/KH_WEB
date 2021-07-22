<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	fmt: fomatting
	sql: Database
	x : xml
	fn : Function
	c: core
 -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Page</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
	<c:forEach var="score" items="${list }">
		<tr>
			<td>
				<c:if test="${score.name eq '이름1' }">
					<c:out value="홍길동"></c:out>
				</c:if>
				<c:choose>
					<c:when test="${score.name eq '이름2' }">
						<c:out value="${score.name } 님!"></c:out>
					</c:when>
					<c:when test="${score.name eq '이름3' }">
						<c:out value="${score.name } 님@@"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="누구지?"></c:out>
					</c:otherwise>
				</c:choose>
			</td>
			<td>${score.kor }</td>
			<td>${score.eng }</td>
			<td>${score.math }</td>
			<td>${score.sum }</td>
			<td>${score.avg }</td>
			<td>${score.grade }</td>
		</tr>
	</c:forEach>
		
	
	</table>

	<c:forEach var="i" begin="1" end="10" step="2">
		${i }<br>
	</c:forEach>
	
	<c:set var="text" value="테스트중" />
	<c:out value="${text }" default="text ~~" />
	
	<hr>
	
	<h2>구구단</h2>
	<table border="1">
		<tr>
			<th colspan="5">구구단</th>
		</tr>
		<c:forEach var="i" begin="2" end="9" step="1">
			<c:forEach var="j" begin="1" end="9" step="1">
				<tr>
				
				<td>${i }</td>
				<td>*</td>
				<td>${j }</td>
				<td>=</td>
				<td>${i*j }</td>
				
				</tr>
			</c:forEach>
		</c:forEach>
	
	
	
	</table>



















</body>
</html>