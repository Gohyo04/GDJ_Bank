package com.gohyo.app.board;

import java.util.List;

import com.gohyo.app.util.Pager;

public interface BoardDAO {
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public Long getTotal() throws Exception;
	
	public int doUpdate() throws Exception;
	
	public int doDelete() throws Exception;

	public int setAdd(BoardDTO boardDTO) throws Exception;
}