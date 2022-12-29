/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-12-16 06:00:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class moneyList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
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

Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;

String sql = "select m1.custno, m1.custname, m1.grade, sum(m2.price) as hap from member_tbl_02 m1 inner join money_tbl_02 m2 on m1.custno = m2.custno group by m1.custno, m1.custname, m1.grade order by hap desc";

try {
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
	pst = conn.prepareStatement(sql);
	rs = pst.executeQuery(); //select => executeQuery()

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header>\n");
      out.write("<!--헤더 구역-->\n");
      out.write("<h1>쇼핑몰 회원관리 ver 1.0</h1>\n");
      out.write("\n");
      out.write("</header>\n");
      out.write("<nav>\n");
      out.write("<!--메뉴 구역 -->\n");
      out.write("<ul>\n");
      out.write(" 		   <li><a href=\"register.jsp\">회원등록</a></li>\n");
      out.write("		   <li><a href=\"list.jsp\">회원목록조회/수정</a></li>\n");
      out.write("		   <li><a href=\"moneyList.jsp\">회원매출조회</a></li>\n");
      out.write("		   <li><a href=\"/\">홈으로...</a></li>\n");
      out.write("</ul>\n");
      out.write("</nav>\n");
      out.write("<section>\n");
      out.write("<h2>회원매출조회</h2>\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("   <th>회원번호</th>\n");
      out.write("   <th>회원성명</th>\n");
      out.write("   <th>고객등급</th>\n");
      out.write("   <th>매출</th>\n");
      out.write("</tr>\n");

	while(rs.next()){
		String grade = "";
		if(rs.getString(3).equals("A")) grade = "VIP";
		if(rs.getString(3).equals("B")) grade = "일반";
		if(rs.getString(3).equals("C")) grade = "직원";

      out.write("\n");
      out.write("<tr>\n");
      out.write("   <td>");
      out.print(rs.getInt(1) );
      out.write("</td>\n");
      out.write("   <td>");
      out.print(rs.getString(2) );
      out.write("</td>\n");
      out.write("   <td>");
      out.print(grade );
      out.write("</td>\n");
      out.write("   <td>");
      out.print(rs.getInt(4) );
      out.write("</td>\n");
      out.write("</tr>\n");
 } 
      out.write("\n");
      out.write("</table>\n");
      out.write("</section>\n");
      out.write("<footer>\n");
      out.write("<!-- 하단 구역 -->\n");
      out.write("<p>HRDKOREA Copyright&copy; 2016 All rights reserved Human Resources Development Service of Korea</p>\n");
      out.write("</footer>\n");
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
