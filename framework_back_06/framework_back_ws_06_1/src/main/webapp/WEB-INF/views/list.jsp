<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    h1 { color: #333; }
    table { border-collapse: collapse; width: 100%; margin-top: 20px; }
    th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
    th { background-color: #3c90e2; color: white; }
    tr:nth-child(even) { background-color: #f2f2f2; }
    tr:hover { background-color: #ddd; }
    .book-img { width: 80px; height: 100px; object-fit: cover; }
    .no-img {
        width: 80px;
        height: 100px;
        background-color: #eee;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #999;
        font-size: 12px;
    }
    a { color: #3c90e2; text-decoration: none; }
    a:hover { text-decoration: underline; }
</style>
</head>
<body>
    <h1>도서 목록</h1>

    <table>
        <thead>
            <tr>
                <th>표지</th>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>
                        <!-- TODO: 이미지 표시 구현
                             - book.img가 있으면 /images/${book.img} 경로로 이미지 표시
                             - book.img가 없으면 "이미지 없음" 텍스트 표시
                             - Hint: c:choose, c:when, c:otherwise 사용
                        -->
                        <c:choose>
                        	<c:when test="${empty book.img }">
								<div class="no-img">이미지 없음</div>
                        	</c:when>
                        	<c:otherwise>
                        	    <img src="${pageContext.request.contextPath}/images/${book.img}"
								     alt="${book.title}" class="book-img"
								     onerror="this.style.display='none'; this.parentElement.innerHTML='<div class=no-img>이미지 없음</div>'">
                        	</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${book.isbn}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/detail/${book.isbn}">${book.title}</a>
                    </td>
                    <td>${book.author}</td>
                    <td><fmt:formatNumber value="${book.price}" pattern="#,###"/>원</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
