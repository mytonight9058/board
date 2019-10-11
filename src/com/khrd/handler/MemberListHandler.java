package com.khrd.handler;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.MemberDao;
import com.khrd.dto.Member;
import com.khrd.jbdc.ConnectionProvider;

public class MemberListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = null;
		conn = ConnectionProvider.getConnection();
		MemberDao dao = MemberDao.getInstance();
		List<Member> select = dao.select(conn);	
		request.setAttribute("list", select);
			
		return "/WEB-INF/view/memberList.jsp";		
		
	}

}
