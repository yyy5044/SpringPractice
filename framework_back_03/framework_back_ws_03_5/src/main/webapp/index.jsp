<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 관리 시스템</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }
        .container { max-width: 600px; margin: 100px auto; text-align: center;
                     background-color: white; padding: 40px; border-radius: 8px;
                     box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        h1 { color: #333; margin-bottom: 10px; }
        p { color: #666; margin-bottom: 30px; }
        .btn { display: inline-block; padding: 12px 24px; background-color: #3c90e2;
               color: white; text-decoration: none; border-radius: 4px; font-size: 16px; }
        .btn:hover { background-color: #1C64D0; }
    </style>
</head>
<body>
    <div class="container">
        <h1>도서 관리 시스템</h1>
        <p>Servlet 기반 도서 + 리뷰 관리</p>
        <a href="${pageContext.request.contextPath}/book?action=list" class="btn">도서 목록 보기</a>
    </div>
</body>
</html>
