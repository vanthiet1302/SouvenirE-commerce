<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/14/2026
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Tạo tài khoản</title>
    <link href="${pageContext.request.contextPath}/assets/css/register.css" rel="stylesheet"/>
</head>
<body>
<main>
    <div class="container">
        <h1>Tạo tài khoản</h1>

        <!-- Container chứa thông báo với chiều cao cố định -->
        <div class="message-container">
            <c:if test="${not empty error}">
                <div class="alert error-text">${error}</div>
            </c:if>
            <c:if test="${not empty success}">
                <div class="alert success-text">${success}</div>
            </c:if>
        </div>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="lastName">Họ</label>
                <input type="text" id="lastName" name="lastName" placeholder="Ví dụ: Nguyễn" required/>
            </div>

            <div class="form-group">
                <label for="firstName">Tên</label>
                <input type="text" id="firstName" name="firstName" placeholder="Ví dụ: An" required/>
            </div>

            <div class="form-group">
                <label for="gender">Giới tính</label>
                <select name="gender" id="gender">
                    <option value="MALE">Nam</option>
                    <option value="FEMALE">Nữ</option>
                    <option value="OTHER">Khác</option>
                </select>
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Ngày sinh</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth" required/>
            </div>

            <div class="form-group full-width">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="email@example.com" required/>
            </div>

            <div class="form-group full-width">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập" required/>
            </div>

            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required/>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Xác nhận</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="••••••••" required/>
            </div>

            <div class="form-group full-width submit-container">
                <input type="submit" value="Đăng ký ngay">
            </div>
        </form>
    </div>
</main>

</body>
</html>
