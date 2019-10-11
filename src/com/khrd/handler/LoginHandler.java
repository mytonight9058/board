package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.MemberDao;
import com.khrd.dto.Member;
import com.khrd.jbdc.ConnectionProvider;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/loginForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {

			String id = request.getParameter("id");
			String password = request.getParameter("password");
						
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				MemberDao dao = MemberDao.getInstance(); 
				Member m = dao.selectIdAndPw(conn, id, password);
				
				if(m == null) {
					
					request.setAttribute("notMatch", true);
					
					return "/WEB-INF/view/loginForm.jsp";
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("Auth", m.getMemberid());
				
				return "index.jsp";
			
			}catch(Exception e) {
				
				e.printStackTrace();
			}finally {
				
				
			}
						
		}

		return null;
	}

}
