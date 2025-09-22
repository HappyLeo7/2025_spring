<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진목록</title>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
 #box{
	width:800px;
	margin:auto;
	margin-top: 30px; 
 }
 #title{
 	text-align:center;
 	font-size : 28px;
 	font-weight: bold;
 	color:#337AB7;
 	text-shadow:1px 1px 1px black;
 	margin-bottom: 50px;
 }
 
 input[value='사진등록'],input[value='로그인'],input[value='회원가입']{
 	width:80px;
 }
</style>

</head>
<body>
	여기가 메인입니다...

<div id="box">
	<h1 id="title">::::PhotoGallery::::</h1>
	<!-- 그리드모델로 가져오기 -->
	<!-- 사진등록 및 로그인정보 -->
	<div class="row">
 	 	<div class="col-sm-4">
 	 		<input class="btn btn-primary" type="button" value="사진등록">
 	 	</div>
		<div class="col-sm-8" style="text-align:right;">
			<!-- 로그인 안된경우 
				현재경로 : /photo/list.do
				이동경로 : /member/login_form.do
			-->
			<c:if test="${empty sessionScope.user }">
				<input type="button" value="로그인" class="btn btn-primary"
				onclick="location.href='${pageContext.request.contextPath}/member/login_form.do'">
				<input type="button" value="회원가입" class="btn btn-info"
				onclick="location.href='../member/insert_form.do'">
			</c:if>
			
			<!-- 로그인 된경우 -->
			<c:if test="${not empty user }">
				<b>${user.mem_name }</b>님 환영합니다.
				<input type="button" value="로그아웃" class="btn btn-primary"
				onclick="location.href='${pageContext.request.contextPath}/member/logout.do'">
			</c:if>
			
		</div>
	</div>

</div>
</body>
</html>