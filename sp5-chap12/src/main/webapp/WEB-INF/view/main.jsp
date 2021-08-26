<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>메인</title>
</head>
<body>
	<p>${result }</p>
	<p><a href="<c:url value="/login" />"><spring:message code="login" /></a>
	<p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
</body>
</html>