<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	request.setCharacterEncoding("utf-8");
	int custno = Integer.parseInt(request.getParameter("custno"));
	
	String sql = "select * from member_tbl_02 where custno=?";

try {
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
	pst = conn.prepareStatement(sql);
	pst.setInt(1, custno);  // ?에 custno 값 set 
	rs = pst.executeQuery(); //select => executeQuery()
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<header>
		<!-- 헤더 구역 -->
		<h1>쇼핑몰 회원관리 ver 1.0</h1>

	</header>
	<nav>
		<!-- 메뉴 구역 -->
		<ul>
			<li><a href="register.jsp">회원등록</a></li>
			<li><a href="list.jsp">회원목록조회/수정</a></li>
			<li><a href="moneyList.jsp">회원매출조회</a></li>
			<li><a href="/">홈으로...</a></li>
		</ul>
	</nav>
	<section>
		<form action="updateProcess.jsp" method="post">
			<table>
				<% if(rs.next()) {
					
				%>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
				<tr>
					<td><input type="text" name="custno" value="<%=rs.getInt(1)%>"></td>
					<td><input type="text" name="custname" value="<%=rs.getString(2)%>"></td>
					<td><input type="text" name="phone" value="<%=rs.getString(3)%>"></td>
					<td><input type="text" name="address" value="<%=rs.getString(4)%>"></td>
					<td><input type="text" name="joindate" value="<%=rs.getString(5).substring(0, 10)%>"></td>
					<td><input type="text" name="grade" value="<%=rs.getString(6)%>"></td>
					<td><input type="text" name="city" value="<%=rs.getString(7)%>"></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="수정">&nbsp;
						<input type="button" value="조회" onclick="location.href='list.jsp'">
					</th>
				</tr>
				<% } %>
			</table>
		</form>
	</section>
	<footer>
		<!-- 하단 구역 -->
		<p>HRDKOREA Copyright&copy; 2016 All rights reserved Human Resources Development Service of Korea</p>
	</footer>
</body>
</html>
<%
} catch (Exception e) {
e.printStackTrace();
} finally {
if (rs != null)
	rs.close();
if (pst != null)
	pst.close();
if (conn != null)
	conn.close();
}
%>