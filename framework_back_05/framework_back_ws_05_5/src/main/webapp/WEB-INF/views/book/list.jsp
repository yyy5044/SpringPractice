<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #3c90e2;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }
        .btn:hover {
            background-color: #1C64D0;
        }
        .btn-delete {
            background-color: #f44336;
            padding: 5px 10px;
            margin-top: 0;
        }
        .btn-delete:hover {
            background-color: #d32f2f;
        }
        a {
            color: #3c90e2;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .action-cell {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .search-form {
            margin-bottom: 20px;
            padding: 15px;
            background-color: #f9f9f9;
            border-radius: 8px;
        }
        .search-form input[type="text"] {
            padding: 10px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        .search-form button {
            padding: 10px 20px;
            background-color: #3c90e2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .search-form button:hover {
            background-color: #1C64D0;
        }
        .search-form a {
            margin-left: 10px;
        }
        .search-result {
            margin: 10px 0;
            color: #666;
        }
    </style>
</head>
<body>
    <h1>도서 목록</h1>

    <!-- ============================================
         [미션] 검색 폼을 완성하세요.
         ============================================
         TODO: 다음을 구현하세요.
         1. form action에 /book/list URL 설정 (GET 방식)
         2. input name="keyword"에 검색어 유지: value="${keyword}"
         3. 검색 버튼 클릭 시 GET 요청으로 /book/list?keyword=검색어
         4. keyword가 있을 때만 "전체 보기" 링크 표시 (c:if 활용)
    -->
    <div class="search-form">
        <form action="${pageContext.request.contextPath}/book/list" method="get">
            <input type="text" name="keyword" value="${keyword}" placeholder="제목으로 검색">
            <button type="submit">검색</button>
            <c:if test="${not empty keyword}">
                <a href="${pageContext.request.contextPath}/book/list">전체 보기</a>
            </c:if>
        </form>
    </div>

    <!-- 검색 결과 표시 -->
    <p class="search-result">
        <c:choose>
            <c:when test="${not empty keyword}">
                "${keyword}" 검색 결과: ${fn:length(books)}건
            </c:when>
            <c:otherwise>
                전체 도서: ${fn:length(books)}건
            </c:otherwise>
        </c:choose>
    </p>

    <a href="${pageContext.request.contextPath}/book/regist" class="btn">새 도서 등록</a>

    <table>
        <thead>
            <tr>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.isbn}</td>
                    <td><a href="${pageContext.request.contextPath}/book/${book.isbn}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${book.price}원</td>
                    <td class="action-cell">
                        <a href="${pageContext.request.contextPath}/book/${book.isbn}">상세</a>
                        <form action="${pageContext.request.contextPath}/book/${book.isbn}/delete"
                              method="post" style="display:inline;"
                              onsubmit="return confirm('정말 삭제하시겠습니까?');">
                            <button type="submit" class="btn btn-delete">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty books}">
                <tr>
                    <td colspan="5" style="text-align: center;">
                        <c:choose>
                            <c:when test="${not empty keyword}">
                                검색 결과가 없습니다.
                            </c:when>
                            <c:otherwise>
                                등록된 도서가 없습니다.
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
