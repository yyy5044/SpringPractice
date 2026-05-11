<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f8f9fa; }
        tr:hover { background-color: #f5f5f5; }
        .btn { display: inline-block; padding: 8px 16px; background-color: #3c90e2;
               color: white; text-decoration: none; border-radius: 4px; margin-top: 20px; }
        .btn:hover { background-color: #1C64D0; }
        a { color: #3c90e2; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>도서 목록</h1>

    <table>
        <thead>
            <tr>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.isbn}</td>
                    <td><a href="${pageContext.request.contextPath}/book?action=detail&isbn=${book.isbn}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${book.price}원</td>
                </tr>
            </c:forEach>
            <c:if test="${empty books}">
                <tr>
                    <td colspan="4" style="text-align: center;">등록된 도서가 없습니다.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/book?action=add-form" class="btn">도서 등록</a>
</body>
</html>
