package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao;
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login 체크2");
		return mdao.selectOne(mvo);
	}
	
	@Override
	public int register(MemberVO mvo) {
		log.info("join 체크2");
		return mdao.insert(mvo);
	}

	@Override
	public int lastLogin(String email) {
		log.info("lastLogin 체크2");
		return mdao.update(email);
	}

	@Override
	public List<MemberVO> getMemList() {
		log.info("memList 체크2");
		return mdao.selectMemList();
	}

	@Override
	public int memUpdate(MemberVO mvo) {
		log.info("update 체크2");
		return mdao.memUpdate(mvo);
	}

	@Override
	public int delete(String email) {
		log.info("delete 체크2");
		return mdao.memDelete(email);
	}
}
