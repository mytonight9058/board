package com.khrd.handler;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.MemberDao;
import com.khrd.dto.Member;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class MemberJoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/joinForm.jsp";
						
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			String memberid = request.getParameter("memberid");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
	
			Connection conn = null;
			
			try {
				
				conn = ConnectionProvider.getConnection();
				
				MemberDao dao = MemberDao.getInstance();
				
				Member member =new Member(memberid, name, password, new Date());
				
				int result = dao.insert(conn, member);
				
				request.setAttribute("result", result);
				
				return "WEB-INF/view/joinResult.jsp";
			
			}catch(Exception e) {
				
				
			}finally {
				JDBCUtil.close(conn);
				
			}

		}
		
		
		return null;
	}

}
