package com.gohyo.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.board.BoardDAO;
import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.gohyo.app.board.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", boardDTO);
	}

	@Override
	public Long getTotal() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(namespace+"setAdd", boardDTO);
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
}
