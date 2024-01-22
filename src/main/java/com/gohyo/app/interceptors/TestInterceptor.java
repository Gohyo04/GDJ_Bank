package com.gohyo.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter{
	
	// DispatcherServlet -> Controller 진입 전 필터링
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return이 true Controller로 진행
		// return이 false Controller 진입 불가
		System.out.println("preHandle Controller 진입 전");
		return true;
	}
	
	// Controller에서 나갈 때 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle Controller 나갈 때");
	}
	
	// JSP를 랜더링 후 ( HTML을 작성 후 응답 나가기 전)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("JSP 랜더링 후");
	}
}
