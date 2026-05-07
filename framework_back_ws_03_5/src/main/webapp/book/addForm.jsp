<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 등록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .form-container { max-width: 400px; padding: 20px; background-color: #f8f9fa; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"] {
            width: 100%; padding: 10px; border: 1px solid #ddd;
            border-radius: 4px; box-sizing: border-box; }
        .btn-group { margin-top: 20px; }
        .btn { display: inline-block; padding: 10px 20px; margin-right: 10px; color: white;
               text-decoration: none; border-radius: 4px; border: none; cursor: pointer; font-size: 14px; }
        .btn-primary { background-color: #3c90e2; }
        .btn-primary:hover { background-color: #1C64D0; }
        .btn-secondary { background-color: #6c757d; }
        .btn-secondary:hover { background-color: #5a6268; }
    </style>
</head>
<body>
    <h1>도서 등록</h1>

    <div class="form-container">
        <form action="${pageContext.request.contextPath}/book" method="post">
            <input type="hidden" name="action" value="add">
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
                <input type="number" id="price" name="price" min="0" required>
            </div>
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">등록</button>
                <a href="${pageContext.request.contextPath}/book?action=list" class="btn btn-secondary">취소</a>
            </div>
        </form>
    </div>
</body>
</html>
