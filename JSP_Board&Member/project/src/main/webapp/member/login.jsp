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
<h1>Login Page</h1>
<form action="/mem/login_auth" method="post">
	email : <input type="text" name="email"><br>
	pwd : <input type="password" name="pwd"><br>
		  <button type="submit">로그인</button>
</form>
</body>
</html>