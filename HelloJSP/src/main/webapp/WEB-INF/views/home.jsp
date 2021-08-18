<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 동적 page include -->
<jsp:include page="/WEB-INF/views/includes/header.jsp">
	<jsp:param value="메인 페이지" name="message"/>
</jsp:include>
	
	<ul>
		<li><a href="<%=request.getContextPath() %>/users?a=joinform">회원가입</a></li>
		<li><a href="<%=request.getContextPath() %>/users?a=loginform">로그인</a></li>
	<h4>GET 전송</h4>
	<!-- 
	- URL로 데이터를 전송
	- 파라미터는 ? 뒤에 파라미터명=파라미터값으로 전송
	- 여러 개의 파라미터 &로 연결
	 -->
	 
	 <p>
	 <a href ="hs?name=Servlet">HelloServlet 요청</a>
	 </p>
	 
	 
	 <h4>POST 전송</h4>
	 
	 <!-- 사용자 입력 데이터 전송을 위한 FORM 태그 -->
	 <form action="hs" method="post">
	 	<label for ="last_name"> 성</label>
	 	<input type = "text" name = "last_name" id="last_name" /><br />
	 	<label for = "first_name"> 이름</label>
	 	<input type = "text" name = "first_name" id="first_name" />
	 	
	 	<input type ="submit" value="전송" />
	 </form>
	 
	 <h4>Emaillist (Model 1)</h4>
	 <p><a href = "/web/emaillist/">이메일 리스트 (Model 1) 목록</a>
	 
	 <h4>EmailList (Model 2:MVC)</h4>
	 <p><a href = "/web/el">이메일 리스트 (Model 2)</a></p>
	 
<!-- 정적 페이지 include -->
<%@ include file ="/WEB-INF/views/includes/footer.jsp" %>
