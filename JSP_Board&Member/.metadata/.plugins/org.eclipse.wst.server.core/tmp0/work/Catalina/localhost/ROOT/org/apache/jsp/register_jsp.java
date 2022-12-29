/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-12-16 01:51:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

//DB연결정보
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;

//오늘날짜 작업
Calendar c = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //mm (시간), MM(월)
String today = sdf.format(c.getTime());
out.print(today);

//가장 마지막에 추가된 회원 번호를 불러오기
String sql = "select max(custno) from member_tbl_02";

try {
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
	pst = conn.prepareStatement(sql);
	rs = pst.executeQuery(); //select => executeQuery()
	int custno = Integer.parseInt("100001");
	if (rs.next()) {
		custno = rs.getInt(1) + 1;
	}

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<header>\n");
      out.write("		<!-- 헤더 구역 -->\n");
      out.write("		<h1>쇼핑몰 회원관리 ver 1.0</h1>\n");
      out.write("\n");
      out.write("	</header>\n");
      out.write("	<nav>\n");
      out.write("		<!-- 메뉴 구역 -->\n");
      out.write("		<ul>\n");
      out.write("			<li><a href=\"register.jsp\">회원등록</a></li>\n");
      out.write("		   <li><a href=\"list.jsp\">회원목록조회/수정</a></li>\n");
      out.write("		   <li><a href=\"moneyList.jsp\">회원매출조회</a></li>\n");
      out.write("		   <li><a href=\"/\">홈으로...</a></li>\n");
      out.write("		</ul>\n");
      out.write("	</nav>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function check_form(f){\n");
      out.write("	if(f.custname.value == \"\"){\n");
      out.write("		alert(\"회원성명이 입력되지 않았습니다\");\n");
      out.write("		f.custname.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	if(f.phone.value == \"\"){\n");
      out.write("		alert(\"전화번호가 입력되지 않았습니다\");\n");
      out.write("		f.phone.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	if(f.address.value == \"\"){\n");
      out.write("		alert(\"주소 입력되지 않았습니다\");\n");
      out.write("		f.address.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	if(f.joindate.value == \"\"){\n");
      out.write("		alert(\"가입일자 입력되지 않았습니다\");\n");
      out.write("		f.joindate.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	if(f.grade.value == \"\"){\n");
      out.write("		alert(\"고객등급이 입력되지 않았습니다\");\n");
      out.write("		f.grade.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	if(f.city.value == \"\"){\n");
      out.write("		alert(\"도시코드가 입력되지 않았습니다\");\n");
      out.write("		f.city.focus();\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("	<section>\n");
      out.write("		<!--본문 구역-->\n");
      out.write("		<h2>홈쇼핑 회원 등록</h2>\n");
      out.write("		<form action=\"joinProcess.jsp\" method=\"post\" onsubmit=\"return check_form(this)\">\n");
      out.write("			<table>\n");
      out.write("				<tr>\n");
      out.write("					<th>회원번호(자동발생)</th>\n");
      out.write("					<td><input type=\"text\" name=\"custno\" value=\"");
      out.print(custno);
      out.write("\" readonly=\"readonly\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>회원성명</th>\n");
      out.write("					<td><input type=\"text\" name=\"custname\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>회원전화</th>\n");
      out.write("					<td><input type=\"text\" name=\"phone\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>회원주소</th>\n");
      out.write("					<td><input type=\"text\" name=\"address\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>가입일자</th>\n");
      out.write("					<td><input type=\"text\" name=\"joindate\" value=\"");
      out.print(today);
      out.write("\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>고객등급</th>\n");
      out.write("					<td><input type=\"text\" name=\"grade\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>도시코드</th>\n");
      out.write("					<td><input type=\"text\" name=\"city\"></td>\n");
      out.write("				</tr>\n");
      out.write("				<tr>\n");
      out.write("					<th colspan=\"2\"><input type=\"submit\" value=\"등록\">\n");
      out.write("						&nbsp; <input type=\"button\" value=\"조회\"\n");
      out.write("						onclick=\"location.href='list.jsp'\"></th>\n");
      out.write("				</tr>\n");
      out.write("			</table>\n");
      out.write("		</form>\n");
      out.write("	</section>\n");
      out.write("	<footer>\n");
      out.write("		<!-- 하단 구역 -->\n");
      out.write("	</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");

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

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
