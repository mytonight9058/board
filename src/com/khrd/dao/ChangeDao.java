package com.khrd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.khrd.dto.Change;

public class ChangeDao {

	private static final ChangeDao dao = new ChangeDao();
	
	public static ChangeDao getInstance() {
		
		return dao;		
	}
	
	private ChangeDao() {

	}
	
	public Change password() {
		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		
		
		
		return null;
	}
	
	
	
	
}
