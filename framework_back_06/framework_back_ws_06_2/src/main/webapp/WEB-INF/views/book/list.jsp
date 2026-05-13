<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #3c90e2; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color: #ddd; }
        .book-img { max-width: 80px; max-height: 80px; }
        .no-img { color: #999; font-style: italic; }
        .btn {
            display: inline-block;
            padding: 8px 16px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .btn:hover { background-color: #1C64D0; }
    </style>
</head>
<body>
    <h1>도서 목록</h1>

    <a href="${pageContext.request.contextPath}/book/add" class="btn">도서 등록</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
                <th>이미지</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td><fmt:formatNumber value="${book.price}" pattern="#,###"/>원</td>
                    <td>
                        <c:if test="${book.img != null}">
                            <img src="${pageContext.request.contextPath}/upload/${book.img}"
                                 class="book-img" alt="도서 이미지">
                        </c:if>
                        <c:if test="${book.img == null}">
                            <span class="no-img">이미지 없음</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty books}">
        <p>등록된 도서가 없습니다.</p>
    </c:if>
</body>
</html>
