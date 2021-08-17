<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록넘버(<%=request.getParameter("no") %>)를 수정합니다.</title>
</head>
<body>
	<h1>등록넘버(<%=request.getParameter("no") %>)를 수정합니다.</h1>
	<form action="<%=request.getContextPath() %>/el" method="POST">
		<input type="hidden" name="action" value="update_process">
		<input type="hidden" name="no" value="<%=request.getParameter("no")%>">
		<label for="last_name" id="last_name">성 : </label>
		<input type="text" name="last_name" value="<%=request.getParameter("last_name") %>"><br/>
		<label for="first_name" id="first_name">이름 : </label>
		<input type="text" name="first_name" value="<%=request.getParameter("first_name") %>"><br/>
		<label for="email" id="email">이메일 : </label>
		<input type="text" name="email" value="<%=request.getParameter("email") %>"><br/>
		<input type="submit" value="수정"/>
	</form>
</body>
</html>