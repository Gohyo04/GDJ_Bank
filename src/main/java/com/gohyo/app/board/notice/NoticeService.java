package com.gohyo.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gohyo.app.board.BoardDAO;
import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardService;
import com.gohyo.app.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		
		// 검색
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
