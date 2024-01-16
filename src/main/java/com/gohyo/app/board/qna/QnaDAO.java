package com.gohyo.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.board.BoardDAO;
import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardFileDTO;
import com.gohyo.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gohyo.app.board.qna.QnaDAO.";
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
	}
	
	public int setReplyUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
		return result;
	}
	
	@Override
	public Long getTotal() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdate() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardFileDTO> getListFiles(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getListFiles", boardDTO);
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}


	
}
