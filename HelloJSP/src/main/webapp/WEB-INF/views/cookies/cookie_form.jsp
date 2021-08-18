<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// example attribute 가져오기
	String cookieValue = (String)request.getAttribute("example");
	if(cookieValue == null) {
		cookieValue= "";
	}
%>    
<jsp:include page="/WEB-INF/views/includes/header.jsp">
<jsp:param value="Cookie Test Form" name="message"/>
</jsp:include>

<h3>Add/Edit Cookies</h3>
<form method = "POST" action="cookies">
	<label for="example">Cookie Value</label>
	<input type="text" name="example" id ="example" value="<%=cookieValue%>"/>
	<input type="submit" value="쿠키 설정">
</form>

<h3>Delete Cookie</h3>
<a href="<%=request.getContextPath()%>/cookies?a=delete">쿠키 삭제</a>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>