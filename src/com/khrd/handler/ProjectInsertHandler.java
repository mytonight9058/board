package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDao;
import com.khrd.dto.Article;
import com.khrd.dto.Project;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ProjectInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/projectInsert.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String proceeding = request.getParameter("proceeding");

			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);
				ProjectDao dao = ProjectDao.getInstance();			
				Project project = new Project(0, name, content, null, null, proceeding);	
				dao.insert(conn,project);
				conn.commit();
				response.sendRedirect(request.getContextPath()+ "/project/list.do");				
				return null;
				
			}catch(Exception e) {
				e.printStackTrace();
				conn.rollback();
			}finally {
				JDBCUtil.close(conn);
			}
					
//			return "insert.do";
		}
			
			
		return null;
	}

}
