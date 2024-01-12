package com.gohyo.app.board;

import java.util.List;

// 겹치는 DAO들을 여기서 미리정의 만들어가면서 매개변수도 다시 입력
public interface BoardDAO {
	
	//totalCount
	public Long getTotalCount()throws Exception;
	
	//list
	public List<BoardDTO> getList()throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//add
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	//update 
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
}
