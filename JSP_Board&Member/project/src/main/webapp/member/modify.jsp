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
<h1>Modify 페이지</h1>
	<form action="/mem/update">
		email: <input type="text" name="email" value="${ses.email }" readonly><br>
		password : <input type="password" name="pwd" value="${ses.pwd }"><br>
		nick_name : <input type="text" name="nick_name" value="${ses.nick_name }"><br>
				   <button type="submit">수정하기</button>
	</form>
</body>
</html>