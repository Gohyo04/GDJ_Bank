package com.gohyo.app.wish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.account.AccountDTO;
import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.product.ProductDTO;

@Service
public class WishService {

	@Autowired
	private WishDAO wishDAO;
	
	public int addWish(AccountDTO accountDTO, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		return wishDAO.addWish(accountDTO);
	}
	
	public List<ProductDTO> getWishlist(MemberDTO memberDTO) {
		return wishDAO.getWishlist(memberDTO);
	}
	
	public int deleteWish(Long[] productNum, MemberDTO memberDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nums", productNum);
		map.put("member", memberDTO);
		
		return wishDAO.deleteWish(map);
	}
}
