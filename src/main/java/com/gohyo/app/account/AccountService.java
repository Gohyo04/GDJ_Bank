package com.gohyo.app.account;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.member.MemberDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int accountAdd(AccountDTO accountDTO, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		Calendar ca = Calendar.getInstance();
		
		accountDTO.setUserName(memberDTO.getUserName());
		accountDTO.setAccountNum(ca.getTimeInMillis());
		
		return accountDAO.accountAdd(accountDTO);
	}
	
	public List<AccountDTO> myAccount(AccountDTO accountDTO){
		return accountDAO.myAccount(accountDTO);
	}
}
