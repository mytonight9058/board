<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$("button").click(function(){
		$.ajax({
			
			url:"${pageContext.request.contextPath}/article/readJson.do",
			type:"get",
			data:{"no":$("#no").val()},
			dataType:"json",
			success:function(res){
				console.log(res)
				//게시물 번호 제목 내용 날짜
				
				var date = new Date(res.regdate);
				
				$("#result").append("<p>" +res.article_no + "</p>");
				$("#result").append("<p>" +res.title + "</p>");
				$("#result").append("<p>" +res.content + "</p>");
				$("#result").append("<p>" +date.getFullYear() + "-"+ (date.getMonth()+1)+ "-"+date.getDate()+ "</p>");
				
			}
			
		})
	})
})

</script>

</head>
<body>

<h1>게시글 상세 보기 데이타 가져오기</h1>
<input type = "text" id = "no"><br>
<button>가져오기</button> 

<div id = "result">결과 데이타</div>



</body>
</html>