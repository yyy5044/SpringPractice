<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>파일명 오류</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f5f5f5;
        }
        .error-container {
            text-align: center;
            padding: 40px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            max-width: 500px;
        }
        .error-icon {
            font-size: 72px;
            color: #ff9800;
        }
        .error-title {
            font-size: 24px;
            color: #333;
            margin: 10px 0;
        }
        .error-message {
            color: #666;
            margin: 20px 0;
            padding: 15px;
            background-color: #fff3e0;
            border-radius: 5px;
        }
        .hint {
            background-color: #e3f0fc;
            padding: 15px;
            border-radius: 5px;
            margin: 20px 0;
            text-align: left;
        }
        .hint h4 { margin-top: 0; color: #1C64D0; }
        .hint code {
            background: #e3f0fc;
            padding: 2px 6px;
            border-radius: 3px;
        }
        .back-link {
            display: inline-block;
            padding: 12px 24px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .back-link:hover { background-color: #1C64D0; }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-icon">!</div>
        <h1 class="error-title">파일명 오류</h1>
        <p class="error-message">${error}</p>

        <div class="hint">
            <h4>올바른 파일명 예시:</h4>
            <ul>
                <li><code>movie_parasite.jpg</code></li>
                <li><code>movie_oldboy.png</code></li>
                <li><code>movie_poster_001.jpg</code></li>
            </ul>
        </div>

        <a href="${pageContext.request.contextPath}/movie/add" class="back-link">다시 시도</a>
    </div>
</body>
</html>
