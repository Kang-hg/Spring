<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<h2>회원 정보 입력</h2>
	<form:form action="main" modelAttribute="registerRequest">
	<p>
		<label>이메일:<br>
		<form:input path="email" />
		</label>
	</p>
	<p>
		<label>비밀번호:<br>
		<form:password path="password" />
		</label>
	</p>
	<input type="submit" value="로그인">
	</form:form>
</body>
</html>