<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/insertform.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
<style>
	.input-box{
	margin: 30px 0}
	
	.container{
		margin:30px auto;
		border: 1px solid #BC8F8F;
		text-align:center;
			border-radius:30px;
	}
	
	h1{
		margin: 30px  0;
	}
	
	
	label{
		font-size:20px;
		font-weight:bold;
	}
	
	.submit-btn{
		width:100px;
		height:50px;
		border: 2px solid #BC8F8F;
		color: 	#333	;
		background-color:#ffffff;
		border-radius:30px;
		margin: 30px 0;
		font-weight: bold;
		font-
	}
	.submit-btn:hover{
		background-color: 	#BC8F8F	;
		color: #ffffff;
		font-weight: bold;
	}
	input{
		border:1px solid #BC8F8F;
		border-radius:30px;
		height:30px;
	}
	textarea{
	border:1px solid #BC8F8F;
		border-radius:30px;
	}
	
	
</style>
</head>
<body>
	<div class="container">
		<h1>방명록 작성 폼</h1>
		<form action="${pageContext.request.contextPath}/guest/insert" method="post">
			<div class="input-box">
				<label for="writer">작성자 : </label>
				<input type="text" id="writer" name="writer" />
			</div>
			<div class="input-box">
				<label for="content">내용 : </label>
				<textarea rows="10" cols="30" id="content" name="content"></textarea>
			</div>
			<div class="input-box">
				<label for="pwd">비밀번호 : </label>
				<input type="password" id="pwd" name="pwd" />
			</div>
			
		<button class="submit-btn" type="submit">등록</button>
		</form>
	</div>
</body>
</html>








