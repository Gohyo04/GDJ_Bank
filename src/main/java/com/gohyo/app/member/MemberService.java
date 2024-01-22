package com.gohyo.app.member;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public int addUser(MemberDTO memberDTO, MultipartFile f) throws Exception{
		int result = memberDAO.addUser(memberDTO);
		
		String path = servletContext.getRealPath("/resources/upload/join");
		
		String fileName = fileManager.fileSave(path, f);
		AvatarDTO avatarDTO = new AvatarDTO();
		
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(f.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		result = memberDAO.addFile(avatarDTO);
		
		return result; 
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		MemberDTO m = memberDAO.getDetail(memberDTO);
		
		if(m != null) {
			if(m.getPassword().equals(memberDTO.getPassword())) {
				return m;
			}else {
				m = null;
			}
		}
		return m;
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		int result = memberDAO.setUpdate(memberDTO);
		return result;
	}
}









