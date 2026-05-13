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
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #3c90e2; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .book-img { max-width: 80px; max-height: 80px; }
        .no-img { color: #999; font-style: italic; }
        .btn {
            display: inline-block;
            padding: 6px 12px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .btn:hover { background-color: #1C64D0; }
    </style>
</head>
<body>
    <h1>도서 목록</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
                <th>이미지</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}원</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty book.img}">
                                <img src="${pageContext.request.contextPath}/images/${book.img}"
                                     class="book-img" alt="도서 이미지">
                            </c:when>
                            <c:otherwise>
                                <span class="no-img">없음</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <%-- TODO: 이미지가 있는 도서에 다운로드 링크를 추가하세요 --%>
                        <c:if test="${not empty book.img }">
                        	<a href="${pageContext.request.contextPath }/book/download/${book.id}">
	                        	다운로드
	                        </a>
                        </c:if> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
