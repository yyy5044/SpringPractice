<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY Cinema - 영화 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #1C64D0;
        }
        .btn-secondary {
            background-color: #666;
        }
        .btn-secondary:hover {
            background-color: #444;
        }
    </style>
</head>
<body>
    <h1>새 영화 등록</h1>

    <form action="${pageContext.request.contextPath}/movie" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="director">감독</label>
            <input type="text" id="director" name="director" required>
        </div>
        <div class="form-group">
            <label for="genre">장르</label>
            <input type="text" id="genre" name="genre" placeholder="미입력 시 '장르 미정'">
        </div>
        <div class="form-group">
            <label for="runningTime">상영시간(분)</label>
            <input type="number" id="runningTime" name="runningTime" required>
        </div>
        <div class="form-group">
            <label for="releaseDate">개봉일</label>
            <input type="date" id="releaseDate" name="releaseDate" required>
        </div>
        <button type="submit" class="btn">등록</button>
        <a href="${pageContext.request.contextPath}/movie" class="btn btn-secondary">취소</a>
    </form>
</body>
</html>
