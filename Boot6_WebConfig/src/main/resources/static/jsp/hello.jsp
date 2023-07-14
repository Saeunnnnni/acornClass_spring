<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:choose>
		<!-- session영역에 id값이 없다면?  -->
			<c:when test="${empty sessionScope.id }">
				<a href="${pageContext.request.contextPath}/users/loginform">로그인</a>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/uesers/info">${id }</a>님 로그인 중
					<a href="${pageContext.request.contextPath}/uesers/logout">로그아웃</a>
					
				</c:otherwise>
			</c:when>
		</c:choose>
		<h1>html</h1>
		<a href="${pageContext.request.contextPath}/">index로</a>
	</div>
</body>
</html>