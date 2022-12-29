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
<h1>게시판 목록 페이지</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="bvo">
		<tr>
			<td>${bvo.bno }</td>
			<td>
			<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }">
				<img alt="없음" src="/_fileUpload/th_${bvo.image_file }">
			</c:if>
			<a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a>
			</td>
			<td>${bvo.writer }</td>
			<td>${bvo.reg_date }</td>
			<td>${bvo.read_count }</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${pgh.prev }">
		<a href="/brd/page?pageNo=${pgh.startPage-1 }&qty=${pgh.pgvo.qty }">prev</a>
		</c:if>
		<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
			<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty }">${i } ｜</a>
		</c:forEach>
		<c:if test="${pgh.next }">
		<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty }">next</a>
		</c:if>
	</div>
	<a href="/index.jsp">인덱스</a>
</body>
</html>