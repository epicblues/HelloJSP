<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome: Join Form</title>
</head>
<body>
	<h1>Join Form</h1>
	
	<form method="POST" action = "<%=request.getContextPath() %>/users">
		<input type="hidden" name="a" value="join">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" /><br />
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password" /><br />
		<label for="email">이메일</label>
		<input type="email" name="email" id="email" /><br />
		<label for="gender">성별</label>
		<input type="radio" name="gender" value="F" checked>여성
		<input type="radio" name="gender" value="M">남성
		<!-- radio -> 같은 name 값 1개만 체크할 수 있다. 그 한개만 전송 
		hidden, password, text 이외에는 다 예외적인 attribute -> 소속이 없을 경우
		text라고 간주하게 된다.
		-->
		<input type="submit" value="가입" />
	</form>
</body>
</html>