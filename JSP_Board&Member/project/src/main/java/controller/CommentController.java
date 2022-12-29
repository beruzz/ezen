package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommentController.class);   
	private CommentService csv;
	private int isOk;

	public CommentController() {
		csv = new CommentServiceImpl();
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI();  // /cmt/list/10
		String pathUri = uri.substring("/cmt/".length());
		String path = pathUri;
		String pathVar = "";
		if(pathUri.contains("/")) {
			path = pathUri.substring(0, pathUri.lastIndexOf("/"));  //list
			pathVar = pathUri.substring(pathUri.lastIndexOf("/")+1); //게시물번호
		}
		log.info(">> uri >>"+uri);
		log.info(">> pathUri >>"+pathUri);
		log.info(">> path >>"+path);
		log.info(">> pathVar >>"+pathVar);

		switch (path) {
		case "post":
			try {
				//js에서 보낸 데이터를 StringBuffer로 읽어들이는 작업
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();  //댓글 객체
				while((line = br.readLine()) != null) {  //값이 남아있다면
					sb.append(line);
				}
				log.info(">> sb : "+sb.toString());
				//객체로 생성
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());  //key : value

				int bno = Integer.parseInt(jsonObj.get("bno").toString()); //object라 String으로 변환
				String writer = jsonObj.get("writer").toString();
				String content = jsonObj.get("content").toString();
				isOk = csv.post(new CommentVO(bno, writer, content));
				log.info(isOk > 0?"OK":"Fail");

				PrintWriter out = res.getWriter(); //PrintWriter로 화면에 출력
				out.print(isOk);
			} catch (Exception e) {
				log.info(">> Comment > post > error");
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<CommentVO> list = csv.getList(Integer.parseInt(pathVar));
				log.info(">> Comment > list > DB Ok");
				//json 형태로 변환
				JSONObject jsonObjt = new JSONObject();
				JSONArray jsonObjList = new JSONArray();

				for(int i=0;i<list.size();i++) {
					jsonObjt = new JSONObject(); //key:value
					jsonObjt.put("cno", list.get(i).getCno());		
					jsonObjt.put("bno", list.get(i).getBno());
					jsonObjt.put("writer", list.get(i).getWriter());
					jsonObjt.put("content", list.get(i).getContent());
					jsonObjt.put("reg_at", list.get(i).getReg_at());

					jsonObjList.add(jsonObjt);
				}
				String jsonData = jsonObjList.toJSONString();

				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				log.info(">> Comment > list > error");
				e.printStackTrace();
			}
			break;
		case "remove":
			try {
				int cno = Integer.parseInt(pathVar);
				isOk = csv.delete(cno);
				log.info(isOk > 0?"delete OK":"delete Fail");
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				log.info(">> Comment > delete > error");
				e.printStackTrace();
			}
			break;
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();  //댓글 객체
				while((line = br.readLine()) != null) {  //값이 남아있다면
					sb.append(line);
				}
				log.info(">> sb : "+sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				int cno = Integer.parseInt(jsonObj.get("cno").toString());
				String content = jsonObj.get("content").toString();
				
				isOk = csv.update(new CommentVO(cno, content));
				log.info(isOk > 0?"모디파이 OK":"모디파이 Fail");
				
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				log.info(">> Comment > 모디파이 > error");
				e.printStackTrace();
			}
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}