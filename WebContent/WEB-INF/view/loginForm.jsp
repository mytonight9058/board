<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href = "css/common.css" type = "text/css" rel ="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src = js/common.js></script>

<script>

$(function(){
	
	$("form").submit(function(){
		
		var result= checkInputEmpty($("input[name]"));
		
		if(result == false){
			
			return false;
		}
		
	})
	
})

</script>

</head>
<body>

<form action = "login.do" method = "post">

<fieldset>

아디 :<input type = "text" name = "id" ><span class = "error">아디 입력</span><br>
비번 :<input type = "text" name = "password" ><span class = "error">비번 입력</span><br>
<input type = "submit" value = "로그인" ><br>

</fieldset>

</form>

<c:if test = "${notMatch == true }">

	아디 비번 일치 안 함

</c:if>

<c:if test = "${notMatch != true }">

	아디 비번 일치 함

</c:if>

</body>
</html>