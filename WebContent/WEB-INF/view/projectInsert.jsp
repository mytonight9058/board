<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "insert.do" method="post">

프로젝트 이름<input type = "text" name = "name"><br>

프로젝트 내용<textarea rows="10" cols="40"></textarea><br>

시작날짜 <input type = "text" name = "Sdate"><br>
마감날짜<input type = "text" name = "Ldate"><br>

상태<select>
<option>준비</option>
<option>진행중</option>
</select><br>

<input type = "submit" value = "저장"> <input type = "reset" value = "취소">

</form>

</body>
</html>