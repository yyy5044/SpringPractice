<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    h1 { color: #333; }
    .detail-container {
        display: flex;
        gap: 30px;
        margin-top: 20px;
        max-width: 800px;
    }
    .book-img-container {
        flex-shrink: 0;
    }
    .book-img {
        width: 200px;
        height: 280px;
        object-fit: cover;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .no-img {
        width: 200px;
        height: 280px;
        background-color: #eee;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #999;
        border-radius: 5px;
    }
    .book-info {
        flex-grow: 1;
    }
    .book-info table {
        width: 100%;
        border-collapse: collapse;
    }
    .book-info th, .book-info td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    .book-info th {
        width: 100px;
        background-color: #f5f5f5;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        background-color: #3c90e2;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        margin-top: 20px;
    }
    .btn:hover { background-color: #1C64D0; }
</style>
</head>
<body>
    <h1>도서 상세 정보</h1>

    <div class="detail-container">
        <div class="book-img-container">
            <!-- TODO: 상세 페이지 이미지 표시 구현
                 - book.img가 있으면 /images/${book.img} 경로로 이미지 표시
                 - book.img가 없으면 "이미지 없음" 텍스트 표시
                 - Hint: c:choose, c:when, c:otherwise 사용
                 - Hint: onerror 속성으로 이미지 로딩 실패 시 대체 텍스트 표시
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
            
        </div>

        <div class="book-info">
            <table>
                <tr>
                    <th>ISBN</th>
                    <td>${book.isbn}</td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <th>저자</th>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td><fmt:formatNumber value="${book.price}" pattern="#,###"/>원</td>
                </tr>
            </table>

            <a href="${pageContext.request.contextPath}/book/list" class="btn">목록으로</a>
        </div>
    </div>
</body>
</html>
