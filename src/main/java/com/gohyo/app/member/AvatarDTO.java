package com.gohyo.app.member;

import com.gohyo.app.files.FileDTO;

public class AvatarDTO extends FileDTO{
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
