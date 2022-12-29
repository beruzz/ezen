package service;

import java.util.List;

import domain.MemberVO;

public interface MemService {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo);
	   
	List<MemberVO> getMemList();
	 

}
