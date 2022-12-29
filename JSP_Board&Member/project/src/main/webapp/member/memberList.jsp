<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List Page</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>이메일</th>
			<th>패스워드</th>
			<th>닉네임</th>
			<th>가입일</th>
			<th>마지막 접속일</th>
		</tr>
		<c:forEach items="${memList }" var="mvo">
		<tr>
			<td>${mvo.email }</td>
			<td>${mvo.pwd }</td>
			<td>${mvo.nick_name }</td>
			<td>${mvo.reg_at }</td>
			<td>${mvo.last_login }</td>
		</tr>
		</c:forEach>
	</table>
<a href="/">index..</a>
</body>
</html>