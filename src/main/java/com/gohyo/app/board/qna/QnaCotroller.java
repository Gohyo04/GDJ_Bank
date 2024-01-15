package com.gohyo.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaCotroller {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String getList(Model model, Pager pager) throws Exception{
		List<BoardDTO> ar = qnaService.getList(pager);
		
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(Model model, BoardDTO boardDTO) throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		
		model.addAttribute("boardDTO",boardDTO);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String setAdd(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setAdd(boardDTO);
		return "redirect:./list";
	}
}
