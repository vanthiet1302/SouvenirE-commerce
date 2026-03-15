<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/15/2026
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div>
    <form action="/login" method="post">
        <div>
            <label for="username">Tên đăng nhập</label>
            <input
                    type="text"
                    name="username"
                    id = "username"
                    placeholder="Nhập tên đăng nhập"
                    required>
        </div>

        <div>
            <label for="password">Mật khẩu</label>
            <input
                    type="password"
                    name="password"
                    id = "password"
                    placeholder="Nhập mật khẩu"
                    required>
        </div>

        <div>
            <input type="submit" value="Submit"/>
        </div>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>
