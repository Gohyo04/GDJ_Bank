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
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"doDelete");
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}
	@Override
	public List<BoardFileDTO> getFileList(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getFileList",boardDTO);
	}
	
	public int setFileDelete(BoardDTO boardDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setFileDelete", boardDTO);
	}
	
}
