package com.khrd.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dto.Article;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ArticleListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArticleDao dao = ArticleDao.getInstance();	
			List<Article> list = dao.select(conn, null);
			request.setAttribute("list",list);
			return "/WEB-INF/view/articleList.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn);
			
		}
			
			return "/WEB-INF/view/articleInsertForm.jsp";		

	}

}
