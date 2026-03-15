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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div>
    <h2>Tạo tài khoản</h2>

    <c:if test="${not empty error}"><p class="error-text">${error}</p></c:if>
    <c:if test="${not empty success}"><p class="success-text">${success}</p></c:if>

    <form action="/register" method="post">
        <div>
            <label for="firstName">Tên</label>
            <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    placeholder="Nhập tên của bạn"
                    required/>
        </div>

        <div>
            <label for="lastName">Họ</label>
            <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    placeholder="Nhập họ của bạn"
                    required/>
        </div>

        <div>
            <label for="gender">Giới tính</label>
            <select name="gender" id="gender">
                <option value="Male">Nam</option>
                <option value="Female">Nữ</option>
                <option value="Other">Khác</option>
            </select>
        </div>

        <div>
            <label for="dateOfBirth">Ngày sinh</label>
            <input
                    type="date"
                    id="dateOfBirth"
                    name="dateOfBirth"
                    required/>
        </div>

        <div>
            <label for="email">Email</label>
            <input
                    type="email"
                    id="email"
                    name="email"
                    placeholder="Nhập email của bạn"
                    required/>
        </div>

        <div>
            <label for="username">Tên đăng nhập</label>
            <input
                    type="text"
                    id="username"
                    name="username"
                    placeholder="Nhập tên đăng nhập của bạn"
                    required/>
        </div>

        <div>
            <label for="password">Mật khẩu</label>
            <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Nhập mật khẩu của bạn"
                    required/>
        </div>

        <div>
            <label for="confirmPassword">Xác minh mật khẩu</label>
            <input
                    type="password"
                    id="confirmPassword"
                    name="confirmPassword"
                    placeholder="Nhập lại mật khẩu của bạn"
                    required/>
        </div>

        <div>
            <input type="submit" value="Submit">
        </div>

    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
