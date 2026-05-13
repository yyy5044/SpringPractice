<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 등록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .form-container {
            max-width: 500px;
            border: 1px solid #ddd;
            padding: 30px;
            border-radius: 8px;
        }
        .form-group { margin-bottom: 20px; }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover { background-color: #1C64D0; }
        a { margin-left: 10px; color: #666; }
        .note { font-size: 12px; color: #666; margin-top: 5px; }
        .warning { color: #f44336; font-weight: bold; }
    </style>
</head>
<body>
    <h1>영화 등록</h1>

    <div class="form-container">
        <form action="${pageContext.request.contextPath}/movie/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>제목</label>
                <input type="text" name="title" required>
            </div>

            <div class="form-group">
                <label>감독</label>
                <input type="text" name="director" required>
            </div>

            <div class="form-group">
                <label>개봉년도</label>
                <input type="number" name="year" min="1900" max="2099" required>
            </div>

            <div class="form-group">
                <label>장르</label>
                <select name="genre" required>
                    <option value="">선택하세요</option>
                    <option value="액션">액션</option>
                    <option value="코미디">코미디</option>
                    <option value="드라마">드라마</option>
                    <option value="스릴러">스릴러</option>
                    <option value="공포">공포</option>
                    <option value="로맨스">로맨스</option>
                    <option value="SF">SF</option>
                </select>
            </div>

            <div class="form-group">
                <label>영화 포스터</label>
                <input type="file" name="file" accept="image/*">
                <p class="note warning">* 파일명은 반드시 "movie_"로 시작해야 합니다!</p>
                <p class="note">예: movie_parasite.jpg, movie_oldboy.png</p>
            </div>

            <div>
                <button type="submit">등록</button>
                <a href="${pageContext.request.contextPath}/movie/list">취소</a>
            </div>
        </form>
    </div>
</body>
</html>
