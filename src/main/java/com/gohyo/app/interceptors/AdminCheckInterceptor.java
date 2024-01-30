package com.gohyo.app.interceptors;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.member.role.RoleDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	//Controller 진입전 Check
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		List<RoleDTO> ar = memberDTO.getRoleDTOs();
		
		System.out.println("관리자 권한 Check Interceptor");
		
		for(RoleDTO r : ar) {
			if(r.getRoleName().equals("ROLE_ADMIN")){
				System.out.println("관리자 입니다.");
				return true;
			}
		}		
		request.setAttribute("msg", "권한이 필요합니다.");
		request.setAttribute("path", "/");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	
	//Controller 나갈때 Check
	
	//JSP 랜더링 후
	
}
