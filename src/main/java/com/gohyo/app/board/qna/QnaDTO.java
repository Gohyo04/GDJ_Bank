package com.gohyo.app.board.qna;

import com.gohyo.app.board.BoardDTO;

public class QnaDTO extends BoardDTO{
	private Long QnaRef;
	private Long QnaStep;
	private Long QnaDepth;
	
	
	public Long getQnaRef() {
		return QnaRef;
	}
	public void setQnaRef(Long qnaRef) {
		QnaRef = qnaRef;
	}
	public Long getQnaStep() {
		return QnaStep;
	}
	public void setQnaStep(Long qnaStep) {
		QnaStep = qnaStep;
	}
	public Long getQnaDepth() {
		return QnaDepth;
	}
	public void setQnaDepth(Long qnaDepth) {
		QnaDepth = qnaDepth;
	}
}

