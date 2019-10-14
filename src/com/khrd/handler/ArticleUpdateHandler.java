package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dto.Article;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ArticleUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			String No = request.getParameter("no");
			int no = Integer.parseInt(No);
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				ArticleDao dao = ArticleDao.getInstance();
				Article article = dao.selectByNo(conn, no);
				request.setAttribute("no",no);
				request.setAttribute("title", article.getTitle());
				request.setAttribute("content", article.getContent());
				
				return "/WEB-INF/view/articleUpdate.jsp";
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}

		}else if(request.getMethod().equalsIgnoreCase("post")) {

			Connection conn = null;
			String No = request.getParameter("no");
			int no = Integer.parseInt(No);
			
			try {
				conn = ConnectionProvider.getConnection();
				
				String title = request.getParameter("title");
				String content = request.getParameter("content");
								
				conn.setAutoCommit(false);
				ArticleDao dao = ArticleDao.getInstance();
				Article article = new Article();
				article.setTitle(title);
				article.setContent(content);
				dao.update(conn, article, no);
				dao.updateContent(conn, article, no);
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
