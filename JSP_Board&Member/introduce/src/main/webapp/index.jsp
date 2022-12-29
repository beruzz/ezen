<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/scroll.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>

	<header id="header">
		<h2 class="title">Title</h2>
		<nav class="menu">
			<ul>
				<li><a href="/" class="btn btn-outline-dark">Home</a></li>
				<li><a href="#tag1" class="btn btn-outline-dark">About</a></li>
				<c:if test="${ses.id eq null }">
					<li><a href="/mc/login" class="btn btn-outline-dark">Login</a></li>
				</c:if>
				<li><a href="/mc/join" class="btn btn-outline-dark">Sign Up</a></li>
				<li><a href="/mc/memList" class="btn btn-outline-dark">Member List</a></li>
			</ul>
			<c:if test="${ses.id ne null && ses.id ne '' }">
				${ses.id }님 로그인 완료 <br>
				<a href="/mc/logout?id=${ses.id }"><button type="button"
						class="btn btn-outline-dark">로그아웃</button></a>
				<br>
			</c:if>
		</nav>
	</header>
			<div class="one">
				<span class="profile"><img src="/images/me.png"
					width="450px;" height="450px" alt=""></span>
				<h3>
					<strong>Hello! I'm HyeongSeok Kim</strong>
				</h3>
			</div>
		<div class="list">
			<div class="two">
				<img class="me" src="/images/me2.png" alt="" width="450px;"
					height="500px">
				<h3 class="intext">
					<strong>What would I lose if I learn coding?<br>Absoultely
						nothing!
					</strong><br> <br> Hello! I'm Kim. Welcome to my homepage.<br>
					After I came back to Korea, I was also in the service fields. <br>
					But I don't want to see myself in the same industry in the few
					years. <br> The reason I want to be a back-end engineer is
					that <br> there is no limits for studying and developing
					myself! <br> Achievement is one of my motivation of my life. <br>
					<br> To be a great developer, <br> achievement and
					developing myself constantly <br> is the most important thing,
					I think.
				</h3>
			</div>
		</div>
		<a id="tag1"></a>
</body>
</html>