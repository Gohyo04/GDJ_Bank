package com.gohyo.app.wish;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gohyo.app.account.AccountDTO;

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
	
}
