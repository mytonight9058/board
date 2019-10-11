package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.MemberDao;
import com.khrd.dto.Member;
import com.khrd.jbdc.ConnectionProvider;

public class ChangeHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/changePwdForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {

			Connection conn = null;
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("Auth");
			String nowP = request.getParameter("nowP");
			String newP = request.getParameter("newP");
						
			try {
				conn = ConnectionProvider.getConnection();
				MemberDao dao = MemberDao.getInstance();
				Member member = new Member(id, null, newP, null);				
				int update = dao.update(conn, member);
					
				return "/WEB-INF/view/changePwdSuccess.jsp";
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				
				
			}
			
			
		}
		
		return null;
	}

}
