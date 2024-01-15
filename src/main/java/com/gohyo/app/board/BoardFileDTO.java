package com.gohyo.app.board;

import com.gohyo.app.files.FileDTO;

public class BoardFileDTO extends FileDTO{
	private Long noticeNum;

	public Long getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}
}
