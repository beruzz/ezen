package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemService;
import service.MemServiceImpl;

@WebServlet("/mc/*")
public class MemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private MemService msv;
	private int isOk;

	public MemController() {
		msv = new MemServiceImpl();
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>uri > " + uri);
		log.info(">>path > " + path);

		switch (path) {

		case "join":
			destPage = "/member/join.jsp";
			break;

		case "register":
			try {
				log.info("리지스터 체크");
				String id = req.getParameter("id");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				int age = Integer.parseInt(req.getParameter("age"));
				isOk = msv.register(new MemberVO(id, password, email, age));
				System.out.println(isOk);
				log.info(">> join >" + (isOk > 0 ? "OK" : "Fail"));
				destPage = "login";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("register error");
			}
			break;
		case "login": 
			destPage = "/member/login.jsp"; 
			break; 
		case "login_auth": 
			try {
				MemberVO mvo = msv.login(new MemberVO( 
						req.getParameter("id"),
						req.getParameter("password"))); 
				log.info("로그인 객체 인풋"); 
				if(mvo != null) {
					HttpSession ses = req.getSession(); 
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60); 
				}else { 
					req.setAttribute("msg_login", 0);
				} 
				destPage="/"; 
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
			break;

		case "logout": 
			try { 
				HttpSession ses = req.getSession(); 
				ses.invalidate();
				destPage="/"; 
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
			break; 
		case "memList": 
			HttpSession ses = req.getSession(); 
			List<MemberVO> memList = msv.getMemList(); 
			ses.setAttribute("memList", memList);
			destPage="/member/memList.jsp"; 
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}