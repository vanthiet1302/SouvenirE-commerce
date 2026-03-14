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

        <div class="input_group">
            <input type="password" name="password" placeholder=" " id="matkhau" minlength="8" required>
            <label for="matkhau">Mật khẩu (Ít nhất 8 ký tự)</label>
            <span class="eye_icon" onclick="togglePassword('matkhau', this)">
                    <i class="fa fa-eye"></i>
                </span>
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
</div>

</body>
</html>
