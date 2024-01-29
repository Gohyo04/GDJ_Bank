package com.gohyo.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(Model model, ProductDTO productDTO, ReplyDTO replyDTO, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		productDTO = productService.getDetail(productDTO,replyDTO);
		
		model.addAttribute("dto", productDTO);
		
		// [
		//  {"userName":"???", "contents:???", "data:???"},
		//  {"userName":"???", "contents:???", "data:???"},
		//  {"userName":"???", "contents:???", "data:???"}
		// ]
		return "product/detail";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		List<ProductDTO> ar = productService.getList(pager);
		
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
		return "product/list";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() throws Exception{
		return "product/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Model model, ProductDTO productDTO) throws Exception{
		int result = productService.add(productDTO);
		
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update(Model model, ProductDTO productDTO, ReplyDTO replyDTO) throws Exception{
		productDTO = productService.getDetail(productDTO,replyDTO);
		model.addAttribute("dto",productDTO);
		
		return "product/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView update(ModelAndView mv, ProductDTO productDTO) throws Exception{
		int result = productService.update(productDTO);
		
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./list");
		
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(Model model, ProductDTO productDTO)throws Exception{
		int result = productService.delete(productDTO);
		
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		return "commons/result";
	}
}
