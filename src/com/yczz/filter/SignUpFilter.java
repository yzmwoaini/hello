package com.yczz.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class SignUpFilter extends HttpFilter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requst=(HttpServletRequest) req;
		HttpServletResponse  response=(HttpServletResponse) resp;
		HttpSession session=requst.getSession(false);
		if(session==null||session.getAttribute("user_name")==null) {
			response.sendRedirect("../login.html");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			chain.doFilter(requst, response);
			
		}
		
	}
	
	
}
