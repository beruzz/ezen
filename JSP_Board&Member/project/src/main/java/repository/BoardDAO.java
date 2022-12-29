package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	int updateCount(int bno);

	int selectCount();

	List<BoardVO> selectList(PagingVO pgvo);

	List<BoardVO> selectList(String email);

	String selectImageFile(int bno);

	

}
