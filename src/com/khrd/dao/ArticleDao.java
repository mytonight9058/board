package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.khrd.dto.Article;
import com.khrd.jbdc.JDBCUtil;

public class ArticleDao {

	private static final ArticleDao dao = new ArticleDao();
	
	public static ArticleDao getInstance() {

		return dao;
	}
	private ArticleDao() {
		
	}

	public int insertArticle(Connection conn, Article art) {
		
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into article values(null,?,?,?,now(),now(),0)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, art.getWriter_id());
			pstmt.setString(2, art.getWriter_name());
			pstmt.setString(3, art.getTitle());

			return pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
	
		}

		return -1;
	}
	
	public int insertContent(Connection conn, String content) {
			PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into article_content values(last_insert_id(),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			return pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);	
		}

		return -1;
	}
	
	public List<Article> select(Connection conn, String content) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Article order by article_no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> list = new ArrayList<>();
			while(rs.next()) {
				
				Article art = new Article(rs.getInt("article_no"), rs.getString("writer_id"),rs.getString("writer_name"),rs.getString("title"),rs.getTimestamp("regdate"), rs.getTimestamp("moddate"), rs.getInt("read_cnt"), null);
				
				list.add(art);
			}
				return list;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);	
			JDBCUtil.close(rs);	
		}
		
		return null;	
	}
	
	public Article selectByNo(Connection conn, int article_no) {
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			String sql = "select * from article as a left join article_content as c on a.article_no = c.article_no where a.article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article_no);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				Article article = new Article(rs.getInt("article_no"),
						rs.getString("writer_id"), rs.getString("writer_name"), rs.getString("title"), rs.getTimestamp("regdate"),
						rs.getTimestamp("moddate"), rs.getInt("read_cnt"),rs.getString("content"));
		
					return article;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);	
			JDBCUtil.close(rs);	
		}

		return null;
	}
	
	public int updateContent(Connection conn, Article article,int article_no) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update article_content set content=? where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1 ,article.getContent());
			pstmt.setInt(2,article_no);
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public int update(Connection conn, Article article,int article_no) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update article set title =? where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1 ,article.getTitle());
			pstmt.setInt(2,article_no);
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	
	
	
	
	
	public int delete(Connection conn, int article_no) {
		
		PreparedStatement pstmt = null;
		
		try{
			String sql = "delete from article where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, article_no);
			return pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(pstmt);		
		}			
		return -1;

	}


	
}
