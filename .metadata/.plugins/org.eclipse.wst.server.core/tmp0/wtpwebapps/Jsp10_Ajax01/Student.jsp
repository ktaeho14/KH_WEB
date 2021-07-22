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
<script type="text/javascript">
	//JSON(JavaScript Object Notation)제이슨
	// {name:value, name:value}
	
	function getParameterValues(){
		var name = "name="+$("#name").val();
		var kor = "kor="+$("#kor").val();
		var eng = "eng="+$("#eng").val();
		var math = "math="+$("#math").val();
		
		return "?"+name+"&"+kor+"&"+eng+"&"+math;
	}
	
	$(function(){
		$("#process").click(function(){
			$.ajax({ 
				url:"CalScore"+getParameterValues(),
				dataType:"json",
				success:function(msg){
					$("#result").html(msg.name + "의 총점은" + msg.sum + "이고, 평균은" + msg.avg +"입니다" );
					
				},
				error:function(){
					alert("실패 ㅜㅜ")
				}
			
			});
			
			
		});
	});
	
	
</script>

</head>
<body>
	<h1>성적 처리 프로그램</h1>
	이름: <input type="text" id="name"><br>
	국어: <input type="text" id="kor"><br>
	영어: <input type="text" id="eng"><br>
	수학: <input type="text" id="math"><br>
	
	<input type="button" id="process" value="성적 처리"><br>
	<br>
	<div id="result"></div>
</body>
</html>