<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="login" /></title>
</head>
<body>
<h2><spring:message code="member.info" /></h2>
	<form:form action="main" modelAttribute="registerRequest">
	<p>
		<label><spring:message code="email" />:<br>
		<form:input path="email" />
		<form:errors path="email" />
		</label>
	</p>
	<p>
		<label><spring:message code="password" />:<br>
		<form:password path="password" />
		<form:errors path="password" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="login" />">
	</form:form>
</body>
</html>