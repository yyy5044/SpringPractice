<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 검색 - 동적 SQL</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }
        h1 { color: #333; border-bottom: 2px solid #3c90e2; padding-bottom: 10px; }
        .search-form { background: white; padding: 20px; border-radius: 8px; margin-bottom: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .form-row { margin-bottom: 12px; display: flex; align-items: center; }
        label { display: inline-block; width: 100px; font-weight: bold; color: #555; }
        select, input[type="text"] { padding: 8px; border: 1px solid #ddd; border-radius: 4px; width: 200px; }
        button { padding: 10px 24px; background-color: #3c90e2; color: white; border: none; border-radius: 4px; cursor: pointer; margin-right: 8px; }
        button:hover { background-color: #1C64D0; }
        button.reset { background-color: #9E9E9E; }
        button.reset:hover { background-color: #757575; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        th { background-color: #3c90e2; color: white; padding: 12px; text-align: left; }
        td { padding: 10px 12px; border-bottom: 1px solid #ddd; }
        tr:hover { background-color: #e3f0fc; }
        .result-count { color: #666; margin-bottom: 10px; }
        .btn-group { margin-top: 10px; }
    </style>
</head>
<body>
    <h1>영화 검색 (if / choose)</h1>

    <div class="search-form">
        <form action="${pageContext.request.contextPath}/movie/search" method="get">
            <div class="form-row">
                <label for="searchType">검색 유형</label>
                <select name="searchType" id="searchType">
                    <option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
                    <option value="title" ${searchType == 'title' ? 'selected' : ''}>제목</option>
                    <option value="director" ${searchType == 'director' ? 'selected' : ''}>감독</option>
                    <option value="genre" ${searchType == 'genre' ? 'selected' : ''}>장르</option>
                </select>
            </div>
            <div class="form-row">
                <label for="keyword">검색어</label>
                <input type="text" name="keyword" id="keyword" value="${keyword}" />
            </div>
            <div class="form-row">
                <label for="orderBy">정렬 기준</label>
                <select name="orderBy" id="orderBy">
                    <option value="title" ${orderBy == 'title' ? 'selected' : ''}>제목</option>
                    <option value="director" ${orderBy == 'director' ? 'selected' : ''}>감독</option>
                    <option value="rating" ${orderBy == 'rating' ? 'selected' : ''}>평점</option>
                    <option value="runningTime" ${orderBy == 'runningTime' ? 'selected' : ''}>상영시간</option>
                    <option value="releaseYear" ${orderBy == 'releaseYear' ? 'selected' : ''}>개봉년도</option>
                </select>
            </div>
            <div class="form-row">
                <label for="orderDir">정렬 방향</label>
                <select name="orderDir" id="orderDir">
                    <option value="asc" ${orderDir == 'asc' ? 'selected' : ''}>오름차순</option>
                    <option value="desc" ${orderDir == 'desc' ? 'selected' : ''}>내림차순</option>
                </select>
            </div>
            <div class="btn-group">
                <button type="submit">검색</button>
                <button type="button" class="reset" onclick="location.href='${pageContext.request.contextPath}/movie/search'">초기화</button>
            </div>
        </form>
    </div>

    <p class="result-count">검색 결과: ${movies.size()}건</p>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
                <th>감독</th>
                <th>장르</th>
                <th>평점</th>
                <th>상영시간</th>
                <th>개봉년도</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${empty movies}">
                <tr>
                    <td colspan="7" style="text-align: center;">검색 결과가 없습니다.</td>
                </tr>
            </c:if>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.rating}</td>
                    <td>${movie.runningTime}분</td>
                    <td>${movie.releaseYear}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>