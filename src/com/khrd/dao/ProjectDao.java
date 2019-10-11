package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.Project;
import com.khrd.jbdc.JDBCUtil;

public class ProjectDao {

	private static final ProjectDao dao = new ProjectDao();
	
	public static ProjectDao getInstance() {

		return dao;
	}
	private ProjectDao() {
		
	}

	public int insert(Connection conn, Project project) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into project values(null, ?, ?,?,?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getContent());
			pstmt.setString(3, project.getSdate());
			pstmt.setString(4, project.getLdate());
			pstmt.setString(5, project.getProceeding());
			
			return pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally {
			JDBCUtil.close(pstmt);
			
		}
		
		return -1;
	}
	
	public List<Project> select(Connection conn,String content){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from project";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Project> list = new ArrayList<>();
			while(rs.next()) {
				
				Project project = new Project(rs.getInt("no"),rs.getString("name"),rs.getString("content"),rs.getString("Sdate"),rs.getString("Ldate"),rs.getString("proceeding"));
				list.add(project);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();	
		}finally {
			JDBCUtil.close(pstmt);
			
		}
		
		return null;
	}
	
	
	
	
	
	
}
