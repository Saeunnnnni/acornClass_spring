
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>


</head>
</head>
<body>	
		<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<a class="logo-img" href="home.jsp">로고이미지</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="">메인화면</a></li>
				<li><a href="">공지사항</a></li>
				<li><a href="">회원관리 게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="active"><a href="${pageContext.request.contextPath}/users/loginform">로그인</a></li>
						<li><a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</body>
</html>




