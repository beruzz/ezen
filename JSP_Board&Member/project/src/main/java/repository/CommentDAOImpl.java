package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CommentMapper.";
	private int isOk;
			
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info(">> comment > post > check3");
		isOk = sql.insert(NS+"add", cvo);
		if(isOk>0)sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> selectList(int bno) {
		log.info(">> comment > list > check3");
		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int delete(int cno) {
		log.info(">> comment > delete > check3");
		isOk = sql.delete(NS+"delete", cno);
		if(isOk>0)sql.commit();
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">> comment > 모디파이 > check3");
		isOk = sql.update(NS+"edit", cvo);
		if(isOk>0)sql.commit();
		return isOk;
	}

}
