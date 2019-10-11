<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href = "${pageContext.request.contextPath }/css/common.css" type = "text/css" rel ="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "${pageContext.request.contextPath}/js/common.js"></script>


<title>Insert title here</title>
</head>
<body>

<form action = "update.do" method ="post" id ="f1">

<input type = "hidden" name = "no" value = "${no }">

제목<input type = "text" name = "title" value ="${title }"><span class = "error"></span><br>

내용<textarea rows ="10" cols="60" name = "content">${content }</textarea><span class = "error">ìë ¥</span><br>

<input type = "submit" value = "수정"><br>

</form>


</body>
</html>