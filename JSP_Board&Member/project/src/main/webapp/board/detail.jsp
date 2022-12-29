<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</head>
<body onload="printCommentList(${bvo.bno})">
	<h1>상세 페이지</h1>
	<div>
	<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }">
		<img alt="없음" src="/_fileUpload/${bvo.image_file }">
	</c:if>
	</div>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<td>작성일자</td>
			<td>${bvo.reg_date }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${bvo.read_count }</td>
		</tr>
	</table>
	<c:if test="${ses.email eq bvo.writer }">
		<a href="/brd/modify?bno=${bvo.bno }"><button type="button">수정</button></a>
		<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
	</c:if>
	<a href="/brd/pageList">리스트</a>
	<div>
		comment line<br> 
		<input type="text" id="cmtWriter" value="${ses.email }" readonly="readonly"><br> 
		<input type="text" id="cmtText" placeholder="Add Comment">
		<button type="button" id="cmtAddBtn">댓글</button>
	</div><br>
	<!-- 댓글 표시 영역 -->
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingOne">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">
					Accordion Item #1</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">content, reg_at</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		const bnoVal = '<c:out value="${bvo.bno}"/>';
	</script>
	<script src="/resources/board_detail.js"></script>
	<script type="text/javascript">
	printCommentList(bnoVal);
	</script>
</body>
</html>