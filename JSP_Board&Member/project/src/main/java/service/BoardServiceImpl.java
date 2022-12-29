package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("insert 체크2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list 체크2");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDeatil(int bno) {
		log.info("detail 체크2");
		int isOk = bdao.updateCount(bno);
		if(isOk > 0) {
			return bdao.selectOne(bno);
	
		}else {
			return null;
		}
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update 체크2");
		return bdao.update(bvo);
	}

	@Override
	public int delete(int bno) {
		log.info("delete 체크2");
		return bdao.delete(bno);
	}

	@Override
	public int getPageCnt() {
		return bdao.selectCount();
	}

	@Override
	public List<BoardVO> getListPage(PagingVO pgvo) {
		
		return bdao.selectList(pgvo);
	}

	@Override
	public List<BoardVO> getMyList(String email) {
		
		return bdao.selectList(email);
	}

	@Override
	public String getFileName(int bno) {
		
		return bdao.selectImageFile(bno);
	}

}
