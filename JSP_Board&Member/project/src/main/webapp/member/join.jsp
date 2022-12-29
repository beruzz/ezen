<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
<h1>Sign up Page</h1>
<form action="/mem/register" method="post">
	email : <input type="text" name="email"><br>
	pwd : <input type="password" name="pwd"><br>
	Nickname : <input type="text" name="nick_name"><br>
		  	   <button type="submit">회원가입</button>
</form>
</body>
</html>