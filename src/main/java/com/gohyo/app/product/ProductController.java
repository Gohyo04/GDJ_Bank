package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView detail(ProductDTO pdto) throws Exception{
		ModelAndView mv = new ModelAndView();
		pdto.setProductNum(pdto.getProductNum());
		pdto = productService.getDetail(pdto);
		
		mv.addObject("dto",pdto);
		mv.setViewName("products/detail");
		return mv;
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() {
		return "products/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView add(ProductDTO pdto, ModelAndView mv, MultipartFile[] photo) throws Exception{
		int result = productService.add(pdto, photo);
		String msg = "실패";
		if(result > 0) {
			msg = "성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		return mv;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mv, ProductDTO pdto) throws Exception{
		int result = productService.delete(pdto);
		
		String msg = "삭제 실패";
		if(result > 0) {
			msg = "삭제 성공";
		}
		mv.addObject("msg",msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
}
