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
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #3c90e2; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .movie-img { max-width: 80px; max-height: 80px; }
        .no-img { color: #999; font-style: italic; }
        .btn {
            display: inline-block;
            padding: 8px 16px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .btn:hover { background-color: #1C64D0; }
    </style>
</head>
<body>
    <h1>영화 목록</h1>

    <a href="${pageContext.request.contextPath}/movie/add" class="btn">영화 등록</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
                <th>감독</th>
                <th>개봉년도</th>
                <th>장르</th>
                <th>이미지</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.year}</td>
                    <td>${movie.genre}</td>
                    <td>
                        <c:if test="${movie.img != null}">
                            <img src="${pageContext.request.contextPath}/upload/${movie.img}"
                                 class="movie-img" alt="영화 포스터">
                        </c:if>
                        <c:if test="${movie.img == null}">
                            <span class="no-img">없음</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
