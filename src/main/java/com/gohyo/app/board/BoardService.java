package com.gohyo.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.util.Pager;

public interface BoardService {
	
	//list
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//add
	public int setAdd(BoardDTO boardDTO, MultipartFile [] attachs) throws Exception;
	
	//update 
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
}
