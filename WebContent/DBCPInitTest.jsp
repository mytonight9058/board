<%@page import="com.khrd.jbdc.JDBCUtil"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	Connection conn = null;
	
	try{
		
		String jdbcDriver = "jdbc:apache:commons:dbcp:board";
		conn = DriverManager.getConnection(jdbcDriver);
		
		
		if(conn != null){
			
			out.print("커넥션 풀에 연결");
		}else{
			
			out.print("커넥션 풀에 연결 실패");
		}
		
	}catch(Exception e){
		
		e.printStackTrace();
	}finally{
	
			JDBCUtil.close(conn);

		
	}

%>



</body>
</html>