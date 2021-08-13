<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.emaillist.dao.*"
	import="com.example.emaillist.vo.*"%>
<%
EmaillistDao dao = new EmaillistDaoImpl();
// 이메일 리스트 받아오기
List<EmailVO> list = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emaillist (Model 1)</title>
</head>
<body>
	<h1>메일링 리스트(Model 1)</h1>

	<!-- 이메일 리스트 표시 -->
	<!--  루프 시작 -->
	<%
	for (EmailVO vo : list) {
	%>
	<table border="1">
		<!-- 행 -->
		<tr>
			<th>등록번호</th>
			<td><%=vo.getNo()%></td>
		</tr>
		<tr>
			<th>성</th>
			<td><%=vo.getLastName()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getFirstName()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=vo.getEmail()%></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=vo.getCreatedAt()%></td>
		</tr>
	</table>
	<%
	}
	%>
	<!-- 루프 끝 -->

	<!-- 작성 폼으로 이동(동적 경로 설정, contextPath는 환경에 따라 변한다) -->
	<p>
		<a href="<%=request.getContextPath()%>/emaillist/form.jsp">추가 이메일
			등록</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/emaillist/form.jsp">추가 이메일
			등록</a>
	</p>

</body>
</html>