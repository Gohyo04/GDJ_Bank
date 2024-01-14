package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController{
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<ProductDTO> ar = productService.getList();
		
		model.addAttribute("list",ar);
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
}
