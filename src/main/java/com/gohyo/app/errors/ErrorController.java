package com.gohyo.app.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/*")
public class ErrorController {
	
	@GetMapping("error400")
	public String error400() {
		return "errors/error";
	}
}
