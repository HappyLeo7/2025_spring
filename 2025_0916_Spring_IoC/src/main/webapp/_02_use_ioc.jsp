<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//Spring 생성한 bean을 관리하는 객체
	// JSP 내장 객체 : request session application out pageContext ... 
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	
	PersonVo p1 = (PersonVo)wac.getBean("p1");
	PersonVo p2 = wac.getBean("p2",PersonVo.class);
	PersonVo p3 = wac.getBean("p3",PersonVo.class);
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	pageContext.setAttribute("p3", p3);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${p1 }<br>
	${p2 }<br>
	${p3 }<br>
</body>
</html>