<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
<style>
	.input-box{
	margin: 30px 0}
	
	.container{
		margin:30px auto;
		border: 1px solid #333;
		text-align:center;
		padding: 30px 0;
		border: 2px solid blue;
		border-radius: 30px;
	}
	
	label{
		font-size:20px;
		font-weight:bold;
	}
	button{
		margin:10px 30px;
	}A
	
	
	
	
</style>
</head>
<body>
	<div class="container">
		<h1>회원정보 수정 양식</h1>
		<form action="${pageContext.request.contextPath }/guest/update" method="post">
		<div class="input-box">
				<label for="num">번호 : </label>
				<input type="text" id="num" name="num" value="${dto.num }" readonly />
			</div>
			<div class="input-box">
				<label for="writer ">작성자 : </label>
				<input type="text" id="writer " name="writer"  value="${dto.writer}"/>
			</div>
			<div class="input-box">
				<label for="content">내용 : </label>
				<textarea col="30" row="10" id="content" name="content">${dto.content }</textarea>
			</div>		
			<div class="input-box">
				<label for="pwd">글 작성시 입력했던 비밀번호</label>
				<input type="password" id="pwd" name="pwd" />
			</div>
			
			<button class="btn btn-outline-primary" type="submit">수정확인</button>
			<button class="btn btn-outline-warning" type="reset">취소</button>
		</form>
	</div>
</body>
</html>