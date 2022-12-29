package repository;

import java.util.List;

import org.json.simple.JSONArray;

import domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> selectList(int bno);

	int delete(int cno);

	int update(CommentVO cvo);

	

	

	

}
