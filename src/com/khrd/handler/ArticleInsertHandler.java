package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ArticleDao;
import com.khrd.dao.MemberDao;
import com.khrd.dto.Article;
import com.khrd.dto.Member;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ArticleInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/articleInsertForm.jsp";
			
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Connection conn = null;			
			try {				
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);
				ArticleDao dao = ArticleDao.getInstance();				
				MemberDao mdao = MemberDao.getInstance();
				
				HttpSession session = request.getSession();
				String writer_id = (String) session.getAttribute("Auth");
				Member member = mdao.selectById(conn,writer_id);
				
				Article ar = new Article(0, writer_id, member.getName(), title, null, null, 0, content);
				
				dao.insertArticle(conn,ar);
				dao.insertContent(conn, content);
				conn.commit();
				
				response.sendRedirect(request.getContextPath()+ "/article/list.do");
				
				return null;
				
			}catch(Exception e) {
				
				e.printStackTrace();
				conn.rollback();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		
		return null;
	}

}
