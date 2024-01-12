package com.gohyo.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@RequestMapping(value="list", method = RequestMethod.GET)
	public void getList() throws Exception{
		
	}
	
	
}
