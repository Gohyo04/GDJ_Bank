package com.gohyo.app.wish;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.account.AccountDTO;
import com.gohyo.app.member.MemberDTO;

@Service
public class WishService {

	@Autowired
	private WishDAO wishDAO;
	
	public int addWish(AccountDTO accountDTO, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		return wishDAO.addWish(accountDTO);
	}
}
