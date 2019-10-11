<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link href = "${pageContext.request.contextPath }/css/common.css" type = "text/css" rel ="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "${pageContext.request.contextPath}/js/common.js"></script>

<script>

$(function(){
	
	$("#f1").submit(function(){
		
		var result = checkInputEmpty($("input[name], textarea"));
		
		if(result == false){
			
			return false;
			
		}
	})
})

</script>


<title>Insert title here</title>
</head>
<body>

<form action = "add.do" method ="post" id ="f1">

제목<input type = "text" name = "title"><span class = "error">입력</span><br>

<textarea rows ="10" cols="60" name = "content"></textarea><span class = "error">입력</span><br>

<input type = "submit" value = "등록"><br>
</form>

</body>
</html>