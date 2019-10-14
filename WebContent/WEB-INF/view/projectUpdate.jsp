<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<form action = "update.do" method="post">

<input type = "hidden" name = "no" value = "${no }">

프로젝트 이름<input type = "text" name = "name" value = "${name }"><br>

프로젝트 내용<textarea rows="10" cols="40">${content }</textarea><br>

시작날짜 <input type = "text" name = "sdate" value = "${sdate }"><br>
마감날짜<input type = "text" name = "ldate" value = "${ldate }"><br>

상태<select name = "proceeding">
<option value ="준비">준비</option>
<option value ="진행중">진행중</option>
</select><br>

<input type = "submit" value = "저장"> <input type = "reset" value = "취소">

</form>



</body>
</html>