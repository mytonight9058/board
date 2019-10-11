<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>


</style>

<title>Insert title here</title>
</head>
<body>



<table>


	<tr>
		<td>번호</td>
		<td>${article.article_no}</td>

	</tr>
	
		<tr>
		<td>작성자</td>
		<td>${article.writer_id}</td>

	</tr>
	
		<tr>
		<td>제목</td>
		<td>${article.title}</td>

	</tr>
	
		<tr>
		<td>내용</td>
		<td>${article.content}</td>

	</tr>
	


</table>

<a href = "list.do">목록</a>  <a href = "update.do?no=${article.article_no }">게시글 수정</a>  <a href = "delete.do?no=${article.article_no }">게시글 삭제</a>


</body>
</html>