package com.gohyo.app.board;

import java.sql.Date;

public class BoardDTO {
	private Long noticeNum;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeDate;
	private Long noticeCount;
	private String noticeContents;
	
	public Long getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public Long getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(Long noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	
	
}
