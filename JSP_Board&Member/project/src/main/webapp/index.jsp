<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>
	body{
		position: absolute;
    	top: 30px;
    	left: 50%;
    	transform: translate(-50%, 0%);
	}
</style>
</head>
<body>
<h1>Board & Member!!</h1>
	
<!-- 로그인 시 표현될 정보 -->
<c:if test="${ses.email ne null && ses.email ne '' }">
	${ses.email } login 하였습니다 <br>
	계정생성일 : ${ses.reg_at }
	마지막 접속 : ${ses.last_login }<br>

	<a href="/member/modify.jsp"><button type="button" class="btn btn-primary">회원정보수정</button></a>
	<a href="/brd/list"><button type="button" class="btn btn-success">내 게시판 목록</button></a>
	<a href="/mem/logout?email=${ses.email }"><button type="button" class="btn btn-warning">로그아웃</button></a><br>
	
</c:if>

<c:if test="${ses.email ne null && ses.email ne '' }">
	<a href="/board/register.jsp" class="btn btn-outline-secondary">Board Register</a>
</c:if>

<a href="/brd/pageList" class="btn btn-outline-secondary">Board List</a>
<c:if test="${ses.email eq null }">
<a href="/mem/login">Log in</a>
</c:if>
<a href="/mem/join" class="btn btn-outline-secondary">Sign Up</a>
<a href="/mem/memList" class="btn btn-outline-secondary">Member List</a><br>

<c:if test="${ses.email ne null && ses.email ne '' }">
	<a href="/mem/remove?email=${ses.email }" class="btn btn-danger">회원탈퇴</a>
</c:if>
</body>
</html>