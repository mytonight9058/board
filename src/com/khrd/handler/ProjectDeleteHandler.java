package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDao;
import com.khrd.jbdc.ConnectionProvider;
import com.khrd.jbdc.JDBCUtil;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = null;

		String no = request.getParameter("no");		
		int No = Integer.parseInt(no);
		
		try {		
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ProjectDao dao  = ProjectDao.getInstance();	
			dao.delete(conn, No);
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
