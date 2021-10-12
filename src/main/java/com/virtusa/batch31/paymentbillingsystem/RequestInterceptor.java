package com.virtusa.batch31.paymentbillingsystem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.virtusa.batch31.paymentbillingsystem.services.JwtUtilService;

import io.jsonwebtoken.Claims;

@Component
public class RequestInterceptor implements HandlerInterceptor {
	
	@Autowired
	private JwtUtilService jwtUtilService;
	
	@Autowired
	private ApiRoleMapping apiRoleMapping;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
//		String token = request.getHeader("token");
//		if(token==null && !jwtUtilService.validateToken(token)) {
//			response.getWriter().write("Unauthorized Request");
//			response.setStatus(401);
//			return false;
//		}
//		String url = request.getRequestURI().toString();
//		Claims claims = jwtUtilService.extractAllClaims(token);
//		String role = (String)claims.get("role");
//		System.out.println(url);
//		System.out.println(role);
//		
//		List<String> allowedRoles = apiRoleMapping.getAllowedRoles(url);
//		System.out.println(allowedRoles);
//		if(allowedRoles.contains(role)) {
//			return true;
//		}
//		else {
//			response.getWriter().write("You are not authorized to access this resource");
//			response.setStatus(401);
//			return false;
//		}
	}
	
	
}
