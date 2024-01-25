package com.gohyo.app.wish;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gohyo.app.account.AccountDTO;
import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.product.ProductDTO;

@Controller
@RequestMapping(value="wishlist")
public class WishController {
	
	@Autowired
	private WishService wishService;
	
	@GetMapping("add")
	public String addWish(Model model, AccountDTO accountDTO, HttpSession session) {
		int result = wishService.addWish(accountDTO,session);
		
		model.addAttribute("result",result);
		model.addAttribute("dto",accountDTO);
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("list")
	public void wishlist(Model model, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<ProductDTO> li = wishService.getWishlist(memberDTO);
		model.addAttribute("list",li);
	}
	
	@PostMapping("delete")
	public String deleteWish(Model model,Long[] productNum, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = wishService.deleteWish(productNum, memberDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
}
