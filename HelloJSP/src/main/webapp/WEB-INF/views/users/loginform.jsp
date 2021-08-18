<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/includes/header.jsp">
	<jsp:param value="로그인" name="message"/>
</jsp:include>
	<form method="POST" action="<%=request.getContextPath() %>/users">
		<input type="hidden" name="a" value="login" />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" /> <br/>
		<label for="password">PassWord</label>
		<input type="password" name="password" id="password" /> <br/>
		<input type="submit" value="Login" /> 
	</form>
<%@ include file = "/WEB-INF/views/includes/footer.jsp" %>