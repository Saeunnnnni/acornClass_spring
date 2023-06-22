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
		<h1>인덱스 페이지입니다.</h1>
		<ul>
			<li><a href="/hello/fortune">오늘의 운세</a></li>
			<!-- 클라이언트한테 공개되지 않은 비공개 폴더 이기 때문에 아래와 같이 경로요청을 할 수 없다.
				/hello/WEB-INF/views/fortune.jsp
				따라서 , 서블릿과 비슷하게 경로를 설정해주면 된다!
			 -->
		</ul>
		
		<h2>공지사항</h2>
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>

	</div>
</body>
</html>