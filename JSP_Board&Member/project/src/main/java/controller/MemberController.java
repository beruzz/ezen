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
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private MemberService msv;

	public MemberController() {
		msv = new MemberServiceImpl();
	}   

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">> uri >"+uri);
		log.info(">> path >"+path);

		switch (path) {
		case "login": //로그인 페이지 열기
			destPage = "/member/login.jsp";
			break;
		case "login_auth": //실제 로그인이 일어나는 케이스	
			try {
				MemberVO mvo = msv.login(
						new MemberVO(
								req.getParameter("email"),
								req.getParameter("pwd")
								));
				log.info("login 객체 input");
				if(mvo != null) {
					//세션 가져오기. 연결된 세션이 없다면 새로 생성
					HttpSession ses = req.getSession();
					//ses로 mvo를 바인딩
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60);  //로그인 유지시간(초단위) 10분 설정
				}else {
					req.setAttribute("msg_login", 0);
				}
				destPage="/";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "join":
			destPage="/member/join.jsp";
			break;
		case "register": //회원가입 DB 저장
			isOk = msv.register(new MemberVO(
						req.getParameter("email"),
						req.getParameter("pwd"),
						req.getParameter("nick_name")
					));
			log.info(">> join >"+(isOk>0?"OK":"Fail"));
			destPage = "login";
			break;
		case "logout":
			try {
				//연결된 세션이 있다면 해당 세션을 가져오기
				HttpSession ses = req.getSession();
				ses.invalidate(); //세션 끊기
				//로그인정보 email 을 주고 로그인 시간 update
				isOk = msv.lastLogin(req.getParameter("email"));
				log.info(">> lastLogin >"+(isOk>0?"OK":"Fail"));
				destPage="/";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "memList":
			HttpSession ses = req.getSession();
			List<MemberVO> memList = msv.getMemList();
			ses.setAttribute("memList", memList);
			destPage="/member/memberList.jsp";
			break;	
		
		case "update":
			try {
				String email = req.getParameter("email");
				String pwd = req.getParameter("pwd");
				String nick = req.getParameter("nick_name");
				isOk = msv.memUpdate(new MemberVO(email, pwd, nick));
				destPage = "memList";
			} catch (Exception e) {
				log.info("업데이트 에러");
				e.printStackTrace();
			}		
			break;
		
		case "remove":
			try {
				log.info("delete 확인");
				String email = req.getParameter("email");
				isOk = msv.delete(email);
				log.info("delete 체크4");
				destPage="memList";
			} catch (Exception e) {
				log.info("delete 에러");
				e.printStackTrace();
			}
		}
		//목적지 주소 값 세팅
		rdp = req.getRequestDispatcher(destPage);
		//정보 싣고 보내기
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
