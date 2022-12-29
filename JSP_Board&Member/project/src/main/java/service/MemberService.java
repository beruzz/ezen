package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO mvo);

	int register(MemberVO memberVO);

	int lastLogin(String email);

	List<MemberVO> getMemList();

	int memUpdate(MemberVO memberVO);

	int delete(String email);

}
