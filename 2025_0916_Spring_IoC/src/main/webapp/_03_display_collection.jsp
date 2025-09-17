<%@page import="java.util.Properties"%>
<%@page import="util.MyProp"%>
<%@page import="java.util.Map"%>
<%@page import="util.MyMap"%>
<%@page import="java.util.Set"%>
<%@page import="util.MySet"%>
<%@page import="java.util.List"%>
<%@page import="util.MyList"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);

	MyList myList = wac.getBean("myListBean",MyList.class);
	List<String> fruit_list = myList.getList();
	pageContext.setAttribute("fr_list", fruit_list);
	
	MySet mySet = wac.getBean("mySetBean",MySet.class);
	Set<String> cunchwri_set= mySet.getSet();
	pageContext.setAttribute("ccr_set", cunchwri_set);
	
	MyMap myMap = wac.getBean("myMapBean",MyMap.class);
	Map<String,String> 수도=myMap.getMap();
	pageContext.setAttribute("수도_map", 수도);
	
	MyProp myprop=wac.getBean("myPropBean",MyProp.class);
	Properties number_prop=myprop.getProp();
	pageContext.setAttribute("number_prop", number_prop);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h4>MyList's list</h4>
<hr>
<ul>
	<c:forEach var="fruit" items="${fr_list}">
		<li>
		 ${fruit }
		</li>
	</c:forEach>
</ul>

<hr>
	<h4>MySet's set</h4>
<hr>
<ul>
	<c:forEach var="ccr" items="${ccr_set}">
		<li>
		 ${ccr }
		</li>
	</c:forEach>
</ul>

<hr>
	<h4>MyMap's map</h4>
<hr>
<ul>
	<c:forEach var="수도" items="${수도_map}">
		<li>
		 [${수도.key }]의 수도는 "${ 수도.value }" 입니다
		</li>
	</c:forEach>
</ul>

<hr>
	<h4>MyProp's prop</h4>
<hr>
<ul>
	<c:forEach var="number" items="${number_prop}">
		<li>
		 키는 [${number.key }]이고 벨류는"${ number.value }" 입니다
		</li>
	</c:forEach>
</ul>


</body>
</html>