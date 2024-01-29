package com.gohyo.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	public String setReply(Model model, ReplyDTO replyDTO, Pager pager, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		
//		int result = replyService.setReply(replyDTO);
		
		List<ReplyDTO> list = replyService.getList(pager, replyDTO);
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("datas", list);
		map.put("pager", pager); 
		
		return "";
	}
	
	@GetMapping("list")
	@ResponseBody
	public Map<String, Object> getList(Pager pager, ReplyDTO replyDTO, Model model) throws Exception{
		List<ReplyDTO> list = replyService.getList(pager, replyDTO);
		
		model.addAttribute("list",list);
		model.addAttribute("pager",pager);
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("datas", list);
		map.put("pager", pager);
		
		return map;
	}
	
	@PostMapping("delete")
	@ResponseBody
	public Map<String, Object> setDelete(Pager pager, ReplyDTO replyDTO) throws Exception{
		replyService.setDelete(replyDTO);
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("datas", ar);
		map.put("pager", pager);
		
		return map;
	}
}















