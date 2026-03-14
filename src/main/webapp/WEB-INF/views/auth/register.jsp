<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/14/2026
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="split_panel right_panel">
    <h2>Tạo tài khoản</h2>

    <c:if test="${not empty error}"><p class="error-text">${error}</p></c:if>
    <c:if test="${not empty success}"><p class="success-text">${success}</p></c:if>

    <form class="signup_form" action="${pageContext.request.contextPath}/register" method="post">
        <div class="input_group">
            <input type="text" name="full_name" placeholder=" " id="full_name" required>
            <label for="full_name">Họ và Tên</label>
        </div>

        <div class="input_group">
            <input type="email" name="email" placeholder=" " id="email" required>
            <label for="email">Địa chỉ Email</label>
        </div>

        <div class="input_group">
            <input type="tel" name="phone" placeholder=" " id="phone" pattern="[0-9]{10,20}" required>
            <label for="phone">Số điện thoại</label>
        </div>

        <div class="row g-3 align-items-center">
            <div class="col-auto">
                <label for="inputPassword6" class="col-form-label">Password</label>
            </div>
            <div class="col-auto">
                <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
            </div>
            <div class="col-auto">
            <span id="passwordHelpInline" class="form-text">
              Must be 8-20 characters long.
            </span>
            </div>
        </div>

        <div class="input_group">
            <input type="password" name="confirm_password" placeholder=" " id="confirm_password" minlength="8" required>
            <label for="confirm_password">Xác nhận mật khẩu</label>
            <span class="eye_icon" onclick="togglePassword('confirm_password', this)">
                    <i class="fa fa-eye"></i>
                </span>
        </div>

        <button type="submit" class="signup_button">ĐĂNG KÝ</button>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
</div>

</body>
</html>
