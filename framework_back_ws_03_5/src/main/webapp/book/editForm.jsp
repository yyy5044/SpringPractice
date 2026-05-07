<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 수정</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .form-container { max-width: 400px; padding: 20px; background-color: #f8f9fa; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"] {
            width: 100%; padding: 10px; border: 1px solid #ddd;
            border-radius: 4px; box-sizing: border-box; }
        input[readonly] { background-color: #e9ecef; }
        .btn-group { margin-top: 20px; }
        .btn { display: inline-block; padding: 10px 20px; margin-right: 10px; color: white;
               text-decoration: none; border-radius: 4px; border: none; cursor: pointer; font-size: 14px; }
        .btn-warning { background-color: #ffc107; color: #333; }
        .btn-warning:hover { background-color: #e0a800; }
        .btn-secondary { background-color: #6c757d; }
        .btn-secondary:hover { background-color: #5a6268; }
    </style>
</head>
<body>
    <h1>도서 수정</h1>

    <div class="form-container">
        <form action="${pageContext.request.contextPath}/book" method="post">
            <input type="hidden" name="action" value="edit">
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
                <input type="number" id="price" name="price" value="${book.price}" min="0" required>
            </div>
            <div class="btn-group">
                <button type="submit" class="btn btn-warning">수정</button>
                <a href="${pageContext.request.contextPath}/book?action=detail&isbn=${book.isbn}" class="btn btn-secondary">취소</a>
            </div>
        </form>
    </div>
</body>
</html>
