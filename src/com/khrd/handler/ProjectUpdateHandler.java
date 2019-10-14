package com.khrd.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dao.ProjectDao;
import com.khrd.dto.Article;
import com.khrd.dto.Project;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("get")) {
			
			String No = request.getParameter("no");
			int no = Integer.parseInt(No);
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				ProjectDao dao = ProjectDao.getInstance();
				Project project = dao.selectBy(conn, no);
				request.setAttribute("no",no);
				request.setAttribute("name", project.getName());
				request.setAttribute("content", project.getContent());
				
				return "/WEB-INF/view/projectUpdate.jsp";
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}		
		}else if(request.getMethod().equalsIgnoreCase("post")) {
				
				Connection conn = null;
				
				String no = request.getParameter("no");
				int No = Integer.parseInt(no);
				
				try {
					conn = ConnectionProvider.getConnection();
					
					String name = request.getParameter("name");
					String content = request.getParameter("content");
									
					conn.setAutoCommit(false);
					ProjectDao dao = ProjectDao.getInstance();
					Project project = new Project();
					project.setName(name);
					project.setContent(content);
					dao.update(conn, project, No);
					dao.updateContent(conn, project, No);
					conn.commit();
					
					return "list.do";		
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(conn);
				}			
		}		
		return null;
	}

}
