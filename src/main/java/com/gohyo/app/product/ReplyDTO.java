package com.gohyo.app.product;

import java.sql.Date;

public class ReplyDTO {
	private Long commentNum;
	private Long productNum;
	private String userName;
	private String commentContents;
	private Date commentDate;
	private int commentJumsu;

	public Long getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommentJumsu() {
		return commentJumsu;
	}
	public void setCommentJumsu(int commentJumsu) {
		this.commentJumsu = commentJumsu;
	}
}
