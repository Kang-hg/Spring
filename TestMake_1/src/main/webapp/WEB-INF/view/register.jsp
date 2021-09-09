<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form action="submit" modelAttribute="registerData">
	<table width="800">
		<tr height="40">
			<td align="center"><b>[회원가입]</b></td>
		</tr>
	</table>
	<table width="700" height="600" cellpadding="0"
		style="border-collapse: collapse; font-size: 9pt;">
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">회원 ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">비밀번호</td>
			<td><form:input path="password" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">비밀번호 확인</td>
			<td><form:input path="conPassword" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">이 름</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">성 별</td>
			<td><form:input path="sung" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">집전화</td>
			<td><form:input path="homeNumber" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">휴대전화</td>
			<td><form:input path="telNumber" /></td>
		</tr>
		<tr height="7">
			<td colspan="3"><hr /></td>
		</tr>
		<tr class="register" height="30">
			<td width="5%" align="center">*</td>
			<td width="15%">이메일</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<input type="submit" value="회원가입">
			<input type="reset" value="취소">
			<!-- 이동 -->
			<input type="button" onclick="location.href='<c:url value="/" />'" value="나가기">
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>