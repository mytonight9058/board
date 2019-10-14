package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDao;
import com.khrd.dto.Project;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ProjectResultHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String No = request.getParameter("no");
		int no = Integer.parseInt(No);
	
	Connection conn = null;
	
		try {
			conn = ConnectionProvider.getConnection();
			ProjectDao dao = ProjectDao.getInstance();
			Project project = dao.selectBy(conn, no);
		
			request.setAttribute("project", project);
			
			return "/WEB-INF/view/projectResult.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn);
		}
	
	
	return null;
	}

}
