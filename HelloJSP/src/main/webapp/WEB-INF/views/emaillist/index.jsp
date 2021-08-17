<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.emaillist.dao.*"
	import="com.example.emaillist.vo.*"%>
<%
// 요청 객체에서 list 속성 받아오기
List<EmailVO> list = (List<EmailVO>)request.getAttribute("list"); // Object 상태로 value 값이 전송되었으므로 이를 맞게 Casting.
SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd : HH시 mm분 ss초");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emaillist (Model 2)</title>
</head>
<body>
	<h1>메일링 리스트(Model 2)</h1>

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
			<td><%=fmt.format(vo.getCreatedAt())%></td>
		</tr>
		<tr align="right"  >
			
			<td colspan="2">
			<form action="<%=request.getContextPath()%>/el" method="POST">
				<input type="hidden" value="delete" name="action">
				<input name="no" value="<%=vo.getNo()%>" type="hidden"> 
				<input type="submit" value="삭제" />
			</form>
			<form action="<%=request.getContextPath()%>/el" method="POST">
				<input type="hidden" value="update" name="action">
				<input name="no" value="<%=vo.getNo()%>" type="hidden"> 
				<input name="first_name" value="<%=vo.getFirstName()%>" type="hidden"> 
				<input name="last_name" value="<%=vo.getLastName()%>" type="hidden"> 
				<input name="email" value="<%=vo.getEmail()%>" type="hidden"> 
				<input type="submit" value="수정" />
			</form>
			</td>
		</tr>
	</table>
	<%
	}
	%>
	<!-- 루프 끝 -->

	<!-- 작성 폼으로 이동(동적 경로 설정, contextPath는 환경에 따라 변한다) -->
	<p>
		<a href="<%=request.getContextPath()%>/el?a=form">추가 이메일
			등록</a>
	</p>
</body>
</html>