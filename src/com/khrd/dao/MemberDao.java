package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.khrd.dto.Member;
import com.khrd.jbdc.JDBCUtil;


public class MemberDao {

	private static final MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		
		return dao;
		
	}
	
	private MemberDao() {
		
		
		
	}
		
	public int insert(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;
		
		
		try {
			
			String sql = "insert into member values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setTimestamp(4, new java.sql.Timestamp(member.getRegdate().getTime()));
			
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JDBCUtil.close(pstmt);
		}
			
		return -1;		
		
	}
	
	public Member selectIdAndPw(Connection conn, String id, String pass) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			String sql = "select * from member where memberid =? and password = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				Member m = new Member( rs.getString("memberid"), rs.getString("name"), rs.getString("password"), rs.getTimestamp("regdate"));
				
				return m;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn);
			JDBCUtil.close(pstmt);
		}
		
		return null;
	}	
	
	public List<Member> select(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from member";			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Member> list = new ArrayList<>();			
			while(rs.next()) {				
				Member member = new Member(rs.getString("memberid"), rs.getString("name"),rs.getString("password"),rs.getDate("regdate"));											
				list.add(member);
			}			
			return list;
			
		}catch(Exception e){			
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}
	
	
		public int update(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;

		try {
			
			String sql = "update member set password = ? where memberid = ?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getMemberid());
						
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			
			JDBCUtil.close(pstmt);
		}

		return -1;
		
	}	
				
		public Member selectById(Connection conn, String memberid) {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "select * from member where memberid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					Member m = new Member(rs.getString("memberid"), rs.getString("name"), rs.getString("password"), rs.getTimestamp("regdate"));
					return m;
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {

				JDBCUtil.close(pstmt);
			}
			
			return null;
		}
		
	
}
	

