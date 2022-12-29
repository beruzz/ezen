package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS = "MemberMapper."; //mapper의 네임스페이스
			
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		log.info("login 체크 3");
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info("join 체크 3");
		int isOk = sql.insert(NS+"reg",mvo);
		if(isOk>0) sql.commit();
		
		return isOk;
	}

	@Override
	public int update(String email) {
		log.info("lastLogin update 체크 3");
		int isOk = sql.update(NS+"last",email);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<MemberVO> selectMemList() {
		
		return sql.selectList(NS+"memList");
	}

	@Override
	public int memUpdate(MemberVO mvo) {
		log.info("update 체크3");
		int isOk = sql.update(NS+"memUpdate", mvo);
		if(isOk > 0){
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int memDelete(String email) {
		log.info("delete 체크3");
		int isOk = sql.delete(NS+"memDelete", email);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
}
