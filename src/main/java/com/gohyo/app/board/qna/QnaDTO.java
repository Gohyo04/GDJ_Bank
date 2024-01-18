package com.gohyo.app.board.qna;

import java.util.List;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardFileDTO;

public class QnaDTO extends BoardDTO{
	private Long qnaRef;
	private Long qnaStep;
	private Long qnaDepth;
	private Integer flag;
	private List<BoardFileDTO> fileDTOs;
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Long getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(Long qnaRef) {
		this.qnaRef = qnaRef;
	}
	public Long getQnaStep() {
		return qnaStep;
	}
	public void setQnaStep(Long qnaStep) {
		this.qnaStep = qnaStep;
	}
	public Long getQnaDepth() {
		return qnaDepth;
	}
	public void setQnaDepth(Long qnaDepth) {
		this.qnaDepth = qnaDepth;
	}
	
}

