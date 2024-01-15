package com.gohyo.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardService;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController{
	
	@Autowired
	private BoardService noticeService;
	
	//list
	//@RequestMapping(value="list", method = RequestMethod.GET)
	@GetMapping("list")
	public String getList(Model model, Pager pager) throws Exception{
		List<BoardDTO> ar = noticeService.getList(pager);
		
		model.addAttribute("list",ar);
		return "board/list";
	}
}
