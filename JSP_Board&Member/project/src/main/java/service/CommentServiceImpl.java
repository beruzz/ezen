package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;


public class CommentServiceImpl implements CommentService {
	private static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl(){
		cdao = new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		log.info(">> comment > post > check2");
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">> comment > list > check2");
		return cdao.selectList(bno);
	}

	@Override
	public int delete(int cno) {
		log.info(">> comment > delete > check2");
		return cdao.delete(cno);
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">> comment > 모디파이 > check2");
		return cdao.update(cvo);
	}
}
