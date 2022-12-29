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

String sql = "select m1.custno, m1.custname, m1.grade, sum(m2.price) as hap from member_tbl_02 m1 inner join money_tbl_02 m2 on m1.custno = m2.custno group by m1.custno, m1.custname, m1.grade order by hap desc";

try {
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
	pst = conn.prepareStatement(sql);
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
<!--헤더 구역-->
<h1>쇼핑몰 회원관리 ver 1.0</h1>

</header>
<nav>
<!--메뉴 구역 -->
<ul>
 		   <li><a href="register.jsp">회원등록</a></li>
		   <li><a href="list.jsp">회원목록조회/수정</a></li>
		   <li><a href="moneyList.jsp">회원매출조회</a></li>
		   <li><a href="/">홈으로...</a></li>
</ul>
</nav>
<section>
<h2>회원매출조회</h2>
<table>
<tr>
   <th>회원번호</th>
   <th>회원성명</th>
   <th>고객등급</th>
   <th>매출</th>
</tr>
<%
	while(rs.next()){
		String grade = "";
		if(rs.getString(3).equals("A")) grade = "VIP";
		if(rs.getString(3).equals("B")) grade = "일반";
		if(rs.getString(3).equals("C")) grade = "직원";
%>
<tr>
   <td><%=rs.getInt(1) %></td>
   <td><%=rs.getString(2) %></td>
   <td><%=grade %></td>
   <td><%=rs.getInt(4) %></td>
</tr>
<% } %>
</table>
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