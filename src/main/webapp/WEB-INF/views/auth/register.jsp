<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/2/2026
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="vi">
    <style>
        main {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
            height: 100%;
            background-color: #ffffff;
        }
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            width: 50%;
            height: 50%;
            border: 1px solid #6b7280;
            padding: 20px;
            box-sizing: border-box;
            border-radius: 5px;
        }
        .label {
            width: 100%;
            display: flex;
            justify-content: left;
            font-size: 0.875rem;
        }
        .email-input {
            width: 100%;
            border: #6b7280 1px groove;
            border-radius: 5px;
        }
        .btn {
            width: 20%;
            height: 15%;
            border-radius: 5px;
            background-color: #6b7280;
        }
    </style>
</head>
<body>
    <main>
        <h2>Đăng ký tài khoản</h2>
        <div class="container">
            <form class="form-horizontal" action="#" method="post">
                <div class="label">
                    <label for="user-email">Nhập Email của bạn </label>
                </div>

                <input type="email"
                       placeholder="Email Address"
                       name="userEmail"
                       id="user-email"
                       class=email-input
                       required
                />

                <input type="submit"
                       content="Gửi"
                       class="btn"
                />
            </form>
        </div>
    </main>
</body>
</html>
