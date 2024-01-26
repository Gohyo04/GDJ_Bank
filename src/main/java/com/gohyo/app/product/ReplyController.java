package com.gohyo.app.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	public String setReply(Model model, ReplyDTO replyDTO, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		 
		
		Map<String, Object> map = replyService.setReply(replyDTO); 
		model.addAttribute("list", map.get("list"));
		return "reply/replyAjaxResult";
	}
	
	@GetMapping("list")
	public String getList(Pager pager, ReplyDTO replyDTO, Model model) throws Exception{
		List<ReplyDTO> list = replyService.getList(pager, replyDTO);
		model.addAttribute("list",list);
		model.addAttribute("pager",pager);
		return "reply/replyAjaxResult";
	}
}
