<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome: Login</title>
</head>
<body>
	<h1>Login</h1>
	<form method="POST" action="<%=request.getContextPath() %>/users">
		<input type="hidden" name="a" value="login" />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" /> <br/>
		<label for="password">PassWord</label>
		<input type="password" name="password" id="password" /> <br/>
		<input type="submit" value="Login" /> 
	</form>
</body>
</html>