package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dto.Article;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ArticleDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = null;
	
		String no = request.getParameter("no");		
		int No = Integer.parseInt(no);		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ArticleDao dao  = ArticleDao.getInstance();
			
			dao.delete(conn,No);
			conn.commit();
			
			return "list.do";
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn);
		}
		
		return null;
	}

}
