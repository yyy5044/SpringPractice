<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 등록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .form-container {
            max-width: 500px;
            border: 1px solid #ddd;
            padding: 30px;
            border-radius: 8px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group textarea { height: 100px; }
        .btn-group { margin-top: 20px; }
        button {
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover { background-color: #1C64D0; }
        a {
            margin-left: 10px;
            color: #666;
        }
        .note {
            font-size: 12px;
            color: #666;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <h1>도서 등록</h1>

    <div class="form-container">
        <!-- enctype="multipart/form-data" 필수 -->
        <form action="${pageContext.request.contextPath}/book/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="isbn">ISBN</label>
                <input type="text" id="isbn" name="isbn" required>
            </div>

            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required>
            </div>

            <div class="form-group">
                <label for="author">저자</label>
                <input type="text" id="author" name="author" required>
            </div>

            <div class="form-group">
                <label for="price">가격</label>
                <input type="number" id="price" name="price" required>
            </div>

            <div class="form-group">
                <label for="desc">설명</label>
                <textarea id="desc" name="desc"></textarea>
            </div>

            <div class="form-group">
                <label for="file">도서 이미지</label>
                <input type="file" id="file" name="file" accept="image/*">
                <p class="note">* 이미지 파일만 업로드 가능 (최대 10MB)</p>
            </div>

            <div class="btn-group">
                <button type="submit">등록</button>
                <a href="${pageContext.request.contextPath}/book/list">취소</a>
            </div>
        </form>
    </div>
</body>
</html>
