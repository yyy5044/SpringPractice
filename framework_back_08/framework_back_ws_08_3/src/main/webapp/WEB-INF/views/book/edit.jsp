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

    <%-- TODO: 수정 폼을 작성하세요 --%>
    <%-- 힌트: action="${pageContext.request.contextPath}/book/update" method="post" --%>
    <form action="${pageContext.request.contextPath}/book/update" method="post">
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <%-- TODO: isbn 필드 (readonly, value="${book.isbn}") --%>
			<input type="text" name="isbn" value="${book.isbn}" readonly>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <%-- TODO: title 입력 필드 (value="${book.title}") --%>
			<input type="text" name="title" value="${book.title}">
        </div>
        <div class="form-group">
            <label for="author">저자</label>
            <%-- TODO: author 입력 필드 (value="${book.author}") --%>
			<input type="text" name="author" value="${book.author}">
        </div>
        <div class="form-group">
            <label for="price">가격</label>
            <%-- TODO: price 입력 필드 (value="${book.price}") --%>
			<input type="text" name="price" value="${book.price}">
        </div>
        <button type="submit" class="btn btn-submit">수정</button>
        <a href="${pageContext.request.contextPath}/book/detail?isbn=${book.isbn}" class="btn btn-cancel">취소</a>
    </form>
</body>
</html>
