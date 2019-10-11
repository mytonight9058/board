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

<form action = "change.do" method= "post">

현재 암호:<input type = "text" name = "nowP"><br>

새 암호:<input type = "text" name = "newP"><br>

<input type = "submit" value = "암호 변경">

</form>
<%-- 
<c:if test ="${}">

암호 불일치

</c:if>

 --%>

</body>
</html>