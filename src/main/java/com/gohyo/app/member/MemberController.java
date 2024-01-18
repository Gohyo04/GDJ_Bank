package com.gohyo.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
//		session.setAttribute("member", null);
//		session.removeAttribute("member");
//		session.removeValue("member");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void getLogin() throws Exception{
		
	}
	
	@PostMapping("login")
	public String getLogin(Model model, MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO == null) {
			model.addAttribute("msg","ID 또는 PW를 확인하세요.");
			return "member/login";
		}
		
		session.setAttribute("member", memberDTO);
		return "redirect:/";
	}
	
	@GetMapping("join")
	public String account() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String account(MemberDTO memberDTO, Model model, MultipartFile f) throws Exception{
		int result = memberService.addUser(memberDTO,f);
		
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path","/");
		return "commons/result";
	}
	
	@GetMapping("mypage")
	public String myPage(HttpSession session, MemberDTO memberDTO) throws Exception{
		memberDTO = (MemberDTO) session.getAttribute("member");
		
		return "member/mypage";
	}
}