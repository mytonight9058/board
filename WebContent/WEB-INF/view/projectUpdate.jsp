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

������Ʈ �̸�<input type = "text" name = "name" value = "${name }"><br>

������Ʈ ����<textarea rows="10" cols="40">${content }</textarea><br>

���۳�¥ <input type = "text" name = "sdate" value = "${sdate }"><br>
������¥<input type = "text" name = "ldate" value = "${ldate }"><br>

����<select name = "proceeding">
<option value ="�غ�">�غ�</option>
<option value ="������">������</option>
</select><br>

<input type = "submit" value = "����"> <input type = "reset" value = "���">

</form>



</body>
</html>