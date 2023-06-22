<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/Guest/list.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
<style>
	
	
	th{
		font-size: 22px;
	}
	
	 tbody >  tr:hover{
		background-color: 	#FFF0F5	;
		font-weight:bold;
	}
	
	.title{
	border : 3px solid 	#E6E6FA;
	height : 60px;
	border-radius: 15px;
	padding: 10px 0 10px 0;
	margin : 30px 0 ;
	
	}
	h2{
	margin:30px 0;
	text-align:center;
	}
	
	a{
	text-decoration:none;
	color: #333}
	table{
	text-align:center;
	border : 3px solid 	#E6E6FA;
	border-radius: 15px;
	}
	
	
	.bi-pencil-square:hover{
		color:	#4682B4	;
	}
	.bi-trash3:hover{
		color: 	#8B0000	;
	}
	button:hover{
		background-color: 	#FFF0F5	;
	}	
	
	button{
		background-color:#ffffff;
		border:none;
	}
	
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	
	<div class="container">
		<h2 class ="title">방명록 목록입니다.</h2>
		<div>
			<a href="${pageContext.request.contextPath}/guest/insertform">글작성</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="tmp" items="${list }">
               <tr>
                  <td>${tmp.num }</td>
                  <td>${tmp.writer }</td>
                  <td><textarea rows="5">${tmp.content }</textarea></td>
                  <td>${tmp.regdate }</td>
                  <td><a href="updateform?num=${tmp.num }">수정</a></td>
                  <td>
                     <form action="delete" method="post">
                        <input type="hidden" name="num" value="${tmp.num }"/>
                        <input type="password" name="pwd" placeholder="비밀번호..."/>
                        <button type="submit">삭제</button>

						</form>
					</td>
               </tr>
            </c:forEach>

			</tbody>
		</table>
	</div>
	
	
	
</body>
</html>





