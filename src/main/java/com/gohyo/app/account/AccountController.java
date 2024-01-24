package com.gohyo.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gohyo.app.product.ProductDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping(value = "account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("add")
	public String accountAdd(AccountDTO accountDTO, Model model) {
		model.addAttribute("dto",accountDTO);
		return "account/add";
	}
	
	@PostMapping("add")
	public ModelAndView accountAdd(HttpSession session, AccountDTO accountDTO, ModelAndView mv) {
		int result = accountService.accountAdd(accountDTO, session);
		
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path","/");
		mv.setViewName("commons/result");
		return mv;
	}
	
	
	@GetMapping("list")
	public String accountList(Model model, Pager pager,ProductDTO productDTO) {
		List<AccountDTO> ar = accountService.myAccount(pager, productDTO);
		
		model.addAttribute("dtos",ar);
		return "account/list";
	}
}
