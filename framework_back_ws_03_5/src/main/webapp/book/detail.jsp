<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 상세</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1, h2 { color: #333; }
        .detail-box { padding: 20px; background-color: #f8f9fa; border-radius: 5px; max-width: 600px; }
        .detail-box table { width: 100%; border-collapse: collapse; }
        .detail-box th, .detail-box td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        .detail-box th { width: 100px; background-color: #e9ecef; }
        .review-section { margin-top: 30px; max-width: 600px; }
        .review-table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        .review-table th, .review-table td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
        .review-table th { background-color: #f8f9fa; }
        .review-form { margin-top: 20px; padding: 15px; background-color: #f8f9fa; border-radius: 5px; }
        .review-form input, .review-form select, .review-form textarea {
            padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .review-form textarea { width: 100%; box-sizing: border-box; }
        .btn-group { margin-top: 20px; }
        .btn { display: inline-block; padding: 8px 16px; margin-right: 8px; color: white;
               text-decoration: none; border-radius: 4px; border: none; cursor: pointer; font-size: 14px; }
        .btn-primary { background-color: #3c90e2; }
        .btn-primary:hover { background-color: #1C64D0; }
        .btn-warning { background-color: #ffc107; color: #333; }
        .btn-warning:hover { background-color: #e0a800; }
        .btn-danger { background-color: #dc3545; }
        .btn-danger:hover { background-color: #c82333; }
        .btn-success { background-color: #3c90e2; }
        .btn-success:hover { background-color: #1C64D0; }
        .btn-sm { padding: 4px 10px; font-size: 12px; }
    </style>
</head>
<body>
    <h1>도서 상세</h1>

    <div class="detail-box">
        <table>
            <tr><th>ISBN</th><td>${book.isbn}</td></tr>
            <tr><th>제목</th><td>${book.title}</td></tr>
            <tr><th>저자</th><td>${book.author}</td></tr>
            <tr><th>가격</th><td>${book.price}원</td></tr>
        </table>
    </div>

    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/book?action=list" class="btn btn-primary">목록</a>
        <a href="${pageContext.request.contextPath}/book?action=edit-form&isbn=${book.isbn}" class="btn btn-warning">수정</a>
        <form action="${pageContext.request.contextPath}/book" method="post" style="display: inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="isbn" value="${book.isbn}">
            <button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까? 관련 리뷰도 함께 삭제됩니다.');">삭제</button>
        </form>
    </div>

    <div class="review-section">
        <h2>리뷰</h2>
        <table class="review-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>내용</th>
                    <th>평점</th>
                    <th>관리</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td>${review.reviewNo}</td>
                        <td>${review.content}</td>
                        <td>
                            <c:forEach begin="1" end="${review.score}">&#9733;</c:forEach>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/book" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="delete-review">
                                <input type="hidden" name="isbn" value="${book.isbn}">
                                <input type="hidden" name="reviewNo" value="${review.reviewNo}">
                                <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('리뷰를 삭제하시겠습니까?');">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty reviews}">
                    <tr>
                        <td colspan="4" style="text-align: center;">등록된 리뷰가 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <div class="review-form">
            <h3>리뷰 등록</h3>
            <form action="${pageContext.request.contextPath}/book" method="post">
                <input type="hidden" name="action" value="add-review">
                <input type="hidden" name="isbn" value="${book.isbn}">
                <div style="margin-bottom: 10px;">
                    <label for="content">내용</label>
                    <textarea id="content" name="content" rows="2" required></textarea>
                </div>
                <div style="margin-bottom: 10px;">
                    <label for="score">평점</label>
                    <select id="score" name="score" required>
                        <option value="5">&#9733;&#9733;&#9733;&#9733;&#9733; (5)</option>
                        <option value="4">&#9733;&#9733;&#9733;&#9733; (4)</option>
                        <option value="3">&#9733;&#9733;&#9733; (3)</option>
                        <option value="2">&#9733;&#9733; (2)</option>
                        <option value="1">&#9733; (1)</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">리뷰 등록</button>
            </form>
        </div>
    </div>
</body>
</html>
