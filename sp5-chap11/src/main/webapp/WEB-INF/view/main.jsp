<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>메인</title>
</head>
<body>
	<%-- <p>환영합니다.</p>  --%>
	<%--<c:if test="${choice }">
	<p>
	
	</c:if>--%>
	<p>${result }</p>
	<p><a href="<c:url value="/login" />">[로그인]</a>
	<p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
</body>
</html>