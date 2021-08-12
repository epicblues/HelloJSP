<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h3>Hello JSP</h3>
	<!-- name 파라미터 받아오기 -->
	<%
	// Java Code
	String name = request.getParameter("name");
	
	// 파라미터가 전송되지 않음.
	if(name == null) {
		name = "Anonymous";
	}
	%>
	<p>Hello! <%= name %></p>
</body>
</html>