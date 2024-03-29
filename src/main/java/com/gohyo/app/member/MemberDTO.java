package com.gohyo.app.member;

import java.util.List;

import com.gohyo.app.member.role.RoleDTO;

public class MemberDTO {
	private String userName;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	
	private AvatarDTO avatarDTO;
	
	// 멤버 한명당 권한이 1개이상
	private List<RoleDTO> roleDTOs;
	
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public AvatarDTO getAvatarDTO() {
		return avatarDTO;
	}
	public void setAvatarDTO(AvatarDTO avatarDTO) {
		this.avatarDTO = avatarDTO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
