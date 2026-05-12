<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY Cinema - 영화 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #3c90e2;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        .btn:hover {
            background-color: #1C64D0;
        }
    </style>
</head>
<body>
    <h1>SSAFY Cinema - 영화 목록</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
                <th>감독</th>
                <th>장르</th>
                <th>상영시간</th>
                <th>상영시간(변환)</th>
                <th>개봉일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.runningTime}분</td>
                    <!-- ============================================ -->
                    <!-- [미션 4] 상영 시간을 "H시간 M분" 형식으로 표시하세요. -->
                    <!-- Movie의 getRunningTimeStr() 메서드를 EL로 호출 -->
                    <!-- 예: 148분 → 2시간 28분 -->
                    <!-- ============================================ -->
                    <td>
                        <!-- === 여기에 코드 작성 === -->
                        ${movie.getRunningTimeStr() }
                    </td>
                    <td>${movie.releaseDate}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty movies}">
                <tr>
                    <td colspan="7" style="text-align: center;">등록된 영화가 없습니다.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/movie/new" class="btn">새 영화 등록</a>
</body>
</html>
