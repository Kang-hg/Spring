<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 조회</title>
</head>
<body>
	<!-- 시발점 입력 유저의 input -->
	<form:form modelAttribute="cmd">
	<p>
		<label>from: <form:input path="from" /></label>
		<form:errors path="from" />
		~
		<label>to: <form:input path="to" /></label>
		<form:errors path="to" />
		<!-- Controller로 데이터 전송 및 실행 -->
		<input type="submit" value="조회">
	</p>
	</form:form>
	<!--  -->
	
	
	<!-- 결과에 대한 output -->
	<!-- if members가 비어있지 않으면 실행 -->
	<c:if test="${! empty members}">
	<table>
		<tr>
			<th>아이디</th><th>이메일</th>
			<th>이름</th><th>가입일</th>
		</tr>
		<!-- 반복문 members(List) 하나씩 member 값을 빼서 var 변수인 mem 대입해서 반복 -->
		<c:forEach var="mem" items="${members }">
		<tr>
			<td>${mem.id }</td>
			<!-- c:url 하이퍼링크 /members/id(가변) -->
			<td><a href="<c:url value="/members/${mem.id }"/>">
				${mem.email }</a></td>
			<td>${mem.name }</td>
			<td><tf:formatDateTime value="${mem.registerDateTime }"
							pattern="yyyy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<!--  -->
	
</body>
</html>












