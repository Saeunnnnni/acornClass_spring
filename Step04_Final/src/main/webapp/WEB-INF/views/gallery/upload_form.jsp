<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/upload_form.jsp</title>
</head>
<body>
	<div class="container">
		<h3>파일 업로드 폼 입니다.</h3>
		<form action="upload" >
		<input type="hidden" name="num" value="${dto.num }" />
		<div>
			<label for="writer">작성자</label>
			<input type="text" id="writer" value="${dto.writer }" disabled/>
		</div>
		
		
		<form id="imageForm" action="${pageContext.request.contextPath}/gallery/list" enctype="multipart/form-data">
			사진
			<input type="file" id="image" name="image" accept=".jpg, .png, .gif"/>
		</form>
		<button type="submit" >업로드</button>
		
	</div>
</body>
</html>