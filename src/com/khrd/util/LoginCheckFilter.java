package com.khrd.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 로그인 안되면 로그인 이동
		// 로그인 되면 그냥 ㄱㄱ
		
		// 로그인 안 된 상태
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("Auth")== null) {
			
		HttpServletResponse response = (HttpServletResponse) res;
		response.sendRedirect(request.getContextPath()+ "/login.do");

		}
		// 로그인 상태
		else{			
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
