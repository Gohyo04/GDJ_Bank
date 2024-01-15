package com.gohyo.app.board.notice;

import java.util.List;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
}
