package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gohyo.app.util.Pager;

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) {
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> ar = productService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("products/list");
		return mv;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView detail(ProductDTO pdto) {
		ModelAndView mv = new ModelAndView();
		pdto = productService.getDetail(pdto);
		
		mv.addObject("dto",pdto);
		mv.setViewName("product/detail");
		return mv;
	}
}
