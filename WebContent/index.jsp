<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>  
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test = "${Auth != null }">

	<h1>[${Auth }]옴? </h1>
	<a href = "logout.do">로그아웃</a>
	<a href = "change.do">비번 변경</a>
	<a href = "${pageContext.request.contextPath }/article/list.do">게시판 리스트</a>

 </c:if>

<c:if test = "${Auth == null }">

 <a href= "join.do">회원 가입</a>

 <a href= "login.do">로그인</a>
 </c:if>
 
 <a href = "member.do">회원 멤버 리스트</a>
 
</body>
</html>