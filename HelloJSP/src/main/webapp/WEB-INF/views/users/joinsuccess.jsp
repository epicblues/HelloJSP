<%@page import="com.example.emaillist.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	UserVo user = (UserVo)request.getAttribute("user");
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome: Join Success</title>
</head>
<body>
	<h1>Join Success</h1>
	<p>가입에 성공하였습니다.</p>
	
</body>
</html>