package com.gohyo.app.account;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int accountAdd(AccountDTO accountDTO) {
		Calendar ca = Calendar.getInstance();
		
		accountDTO.setProductNum(accountDTO.getProductNum());
		accountDTO.setUserName(accountDTO.getUserName());
		accountDTO.setAccountNum(ca.getTimeInMillis());
		
		return accountDAO.accountAdd(accountDTO);
	}
}
