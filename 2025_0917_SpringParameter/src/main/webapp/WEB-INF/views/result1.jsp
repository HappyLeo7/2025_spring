<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
	<h4> 낱개로 받기 결과</h4>
<hr>
이름 : ${requestScope.name } <br>
나이 : ${requestScope.age } <br>
전화 : ${requestScope.tel } <br>

<a href="input_param.html">다시하기</a>
</body>
</html>