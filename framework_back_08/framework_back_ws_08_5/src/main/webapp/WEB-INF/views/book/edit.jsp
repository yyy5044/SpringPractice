<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 수정</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"] { width: 300px; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        input[readonly] { background-color: #eee; }
        .btn { display: inline-block; padding: 8px 16px; color: white; text-decoration: none; border-radius: 4px; border: none; cursor: pointer; font-size: 14px; }
        .btn-submit { background-color: #3c90e2; }
        .btn-submit:hover { background-color: #1C64D0; }
        .btn-cancel { background-color: #888; }
        .btn-cancel:hover { background-color: #666; }
    </style>
</head>
<body>
    <h1>도서 수정</h1>

    <form action="${pageContext.request.contextPath}/book/update" method="post">
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <input type="text" id="isbn" name="isbn" value="${book.isbn}" readonly>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" value="${book.title}" required>
        </div>
        <div class="form-group">
            <label for="author">저자</label>
            <input type="text" id="author" name="author" value="${book.author}" required>
        </div>
        <div class="form-group">
            <label for="price">가격</label>
            <input type="number" id="price" name="price" value="${book.price}" required>
        </div>
        <button type="submit" class="btn btn-submit">수정</button>
        <a href="${pageContext.request.contextPath}/book/detail?isbn=${book.isbn}" class="btn btn-cancel">취소</a>
    </form>
</body>
</html>
