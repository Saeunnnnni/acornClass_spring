<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>

</head>
<body>
	<div class="container">
		<p>메인 화면</p>
		
		<li><a href="${pageContext.request.contextPath}/member/list">회원 활동 분석 게시판</a></li>
		
		<li><a href="${pageContext.request.contextPath}/users/loginform">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a></li>
	</div>
</body>
</html>









