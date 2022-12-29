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
<h1>게시판 수정 페이지</h1>

<form action="/brd/update" method="post" enctype="multipart/form-data">
번호 : <input type="text" name="bno" value="${bvo.bno }" readonly><br>
제목 : <input type="text" name="title" value="${bvo.title }"><br>
내용 : <textarea rows="3" cols="30" name="content">${bvo.content }</textarea>
이미지파일 :
	  <input type="hidden" name="image_file" value="${bvo.image_file }">
	  <input type="file" name="new_file" accept="image/png, image/jpg, image/jpeg, image/gif">
	  <button type="submit">수정하기</button>
</form>
</body>
</html>