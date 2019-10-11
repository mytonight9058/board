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

<a href = "insert.do">새 프로젝트 등록</a>

<table>

	<tr>
		<td>프로젝트 이름</td>
		
	</tr>
	
	<tr>
		<td>시작 날짜</td>
	</tr>
	
	<tr>
		<td>종료 날짜</td>
	</tr>
	
	<tr>
		<td>상태</td>
	</tr>
	
<c:forEach var = "project" items = "${list}">

	<tr>
		<td>${project.name }</td>
	</tr>
	
	<tr>
		<td>${project.Sdate }</td>
	</tr>
	
	<tr>
		<td>$project.Ldate }</td>
	</tr>

	<tr>
		<td>${project.proceeding }</td>
	</tr>

</c:forEach>

</table>


</body>
</html>