<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
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
        .error-code { font-size: 72px; color: #f44336; margin: 0; }
        .error-title { font-size: 24px; color: #333; margin: 10px 0; }
        .error-message {
            color: #666;
            margin: 20px 0;
            padding: 15px;
            background-color: #ffebee;
            border-radius: 5px;
        }
        .back-link {
            display: inline-block;
            padding: 12px 24px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <p class="error-code">500</p>
        <h1 class="error-title">서버 오류</h1>
        <p class="error-message">${error}</p>
        <a href="/" class="back-link">홈으로 돌아가기</a>
    </div>
</body>
</html>
