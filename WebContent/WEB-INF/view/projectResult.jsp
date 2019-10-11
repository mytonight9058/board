<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

table,td{
	border:1px solid black;
}
table{
	border-collapse: collapse;
}

</style>

</head>
<body>

<table>

	<tr>
		<td>프로젝트 이름</td>
		
		<td>${project.name }</td>
		
	</tr>
	
	<tr>
		<td>프로젝트 내용</td>
		

		<td>${project.sdate }</td>

	</tr>
	
	<tr>
		<td>시작 날짜</td>
		
		<td>${project. }</td>

	</tr>
	
	<tr>
		
		<td>종료 날짜</td>		

		<td>${project. }</td>

	</tr>
	
	<tr>	
		<td>상태</td>
		
		<td>${project. }</td>

	</tr>

</table>

<a href = "update.do">수정</a>  <a href = "delete.do">삭제</a>  <a href = "list.do">돌아가기</a>
 

</body>
</html>