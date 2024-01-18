package com.gohyo.app.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardService;
import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController{
	
	@Autowired
	private BoardService noticeService;
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String setAdd(BoardDTO boardDTO, MultipartFile [] attachs, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		boardDTO.setNoticeWriter(memberDTO.getUserName());
		int result = noticeService.setAdd(boardDTO, attachs);
		return "redirect:./list";
	}
	
	//list
	//@RequestMapping(value="list", method = RequestMethod.GET)
	@GetMapping("list")
	public String getList(Model model, Pager pager) throws Exception{
		List<BoardDTO> ar = noticeService.getList(pager);
		
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		
		model.addAttribute("boardDTO",boardDTO);
		return "board/detail";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO, MultipartFile[] attachs)throws Exception{
		int result = noticeService.setUpdate(boardDTO, attachs);
		return "redirect:./detail?noticeNum="+boardDTO.getNoticeNum();
	}
	
	
	@PostMapping("delete")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.delete(boardDTO);
		return "redirect:./list";
	}
}













