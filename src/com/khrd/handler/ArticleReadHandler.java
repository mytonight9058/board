package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dto.Article;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ArticleReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			String sNo = request.getParameter("no");
			int no = Integer.parseInt(sNo);
		
		Connection conn = null;
		
			try {
				conn = ConnectionProvider.getConnection();
				ArticleDao dao = ArticleDao.getInstance();
				Article article = dao.selectByNo(conn, no);
			
				request.setAttribute("article", article);
				
				return "/WEB-INF/view/articleRead.jsp";
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				JDBCUtil.close(conn);
			}
		
		
		return null;
	}

}
