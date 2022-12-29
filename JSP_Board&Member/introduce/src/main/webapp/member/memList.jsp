<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이메일</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${memList }" var="mvo">
		<tr>
			<td>${mvo.id }</td>
			<td>${mvo.password }</td>
			<td>${mvo.email }</td>
			<td>${mvo.age }</td>
		</tr>
		</c:forEach>		
	</table>
	<a href="/">홈으로</a>
</body>
</html>