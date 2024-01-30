package com.gohyo.app.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControlelr {
	
	@ExceptionHandler(NullPointerException.class)
	public String handler1() {
		System.out.println("NullException 에러발생");
		return "errors/error";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handler2() {
		System.out.println("RunTimeException 에러발생");
		return "errors/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handler3() {
		System.out.println("Exception 에러발생");
		return "errors/error";
	}
	
	@ExceptionHandler(Throwable.class)
	public String handler4() {
		System.out.println("Throws 에러발생");
		return "errors/error";
	}
}
