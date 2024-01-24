package com.gohyo.app.account;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.product.ProductDTO;
import com.gohyo.app.util.Pager;

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
	
	public List<AccountDTO> myAccount(Pager pager,ProductDTO productDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pager", pager);
		map.put("product", productDTO);
		
		return accountDAO.myAccount(map);
	}
}
