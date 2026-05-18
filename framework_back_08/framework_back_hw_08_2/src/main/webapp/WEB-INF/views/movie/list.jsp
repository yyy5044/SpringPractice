<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 목록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #3c90e2; color: white; }
        tr:hover { background-color: #f5f5f5; }
        a { color: #3c90e2; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .btn { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #3c90e2; color: white; text-decoration: none; border-radius: 4px; }
        .btn:hover { background-color: #1C64D0; color: white; }
    </style>
</head>
<body>
    <h1>영화 목록</h1>

    <a href="/movie/regist" class="btn">영화 등록</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
                <th>감독</th>
                <th>장르</th>
                <th>상영시간</th>
            </tr>
        </thead>
        <tbody>
            <%-- TODO: c:forEach를 사용하여 movies 목록을 출력하세요 --%>
            <%-- 힌트: <c:forEach var="movie" items="${movies}"> --%>
            <%-- 제목에 상세 페이지 링크를 걸어야 합니다: /movie/detail/${movie.id} --%>
            <%-- 상영시간 출력: ${movie.runningTime}분 --%>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>${movie.id}</td>
					<td><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.title}</a></td>
					<td>${movie.director}</td>
					<td>${movie.genre}</td>
					<td>${movie.runningTime}</td>
				</tr>
			</c:forEach>
		
            <%-- TODO: 영화가 없을 때 "등록된 영화가 없습니다." 메시지를 출력하세요 --%>
            <%-- 힌트: <c:if test="${empty movies}"> --%>
			<c:if test="${empty movies}">
				등록된 영화가 없습니다.
			</c:if>
        </tbody>
    </table>
</body>
</html>
