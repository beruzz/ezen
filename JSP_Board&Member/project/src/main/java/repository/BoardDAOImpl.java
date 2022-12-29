package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;
import service.BoardServiceImpl;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private SqlSession sql;
	private final String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		int isOk = sql.insert(NS+"add", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("list 체크3");
		return sql.selectList(NS+"list");
		
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info("detail 체크3");
		return sql.selectOne(NS+"detail", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update 체크3");
		int isOk = sql.update(NS+"update", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info("delete 체크3");
		int isOk = sql.delete(NS+"delete", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int updateCount(int bno) {
		int isOk = sql.update(NS+"count", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int selectCount() {
		return sql.selectOne(NS+"cnt");
	}

	@Override
	public List<BoardVO> selectList(PagingVO pgvo) {
		return sql.selectList(NS+"pagingList", pgvo);
	}

	@Override
	public List<BoardVO> selectList(String email) {
		
		return sql.selectList(NS+"myList", email);
	}

	@Override
	public String selectImageFile(int bno) {
		return sql.selectOne(NS+"imgFile", bno);
	}
}
