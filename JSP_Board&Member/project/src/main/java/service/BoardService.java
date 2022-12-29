package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO getDeatil(int bno);

	int update(BoardVO boardVO);

	int delete(int bno);

	int getPageCnt();

	List<BoardVO> getListPage(PagingVO pgvo);

	List<BoardVO> getMyList(String email);

	String getFileName(int bno);

}
