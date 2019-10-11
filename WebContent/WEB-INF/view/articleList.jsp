<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

table{
	border-collapse: collapse;
}
td{
	border:1px solid gray;
	padding:5px;
}

</style>

</head>
<body>

<a href= "add.do">등록하기</a>

<table>

	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>아디</td>
		<td>조회수</td>	
	</tr>
	
<c:forEach var = "article" items = "${list}">

	<tr>
		<td>${article.article_no}</td>
		<td><a href = "read.do?no=${article.article_no }">${article.title }</a></td>
		<td>${article.writer_id }</td>
		<td>${article.read_cut }</td>	
	</tr>

</c:forEach>

</table>


</body>
</html>