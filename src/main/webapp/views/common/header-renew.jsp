<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<header class="navbar">
  <div class="top-bar page-shell">
    <div class="top-bar__left">
      <a href="${pageContext.request.contextPath}/home">Seller Center</a>
      <span class="divider-header">|</span>
      <div class="dropdown">
        <button class="dropdown__trigger" type="button" aria-expanded="false">Tiếng Việt</button>
        <ul class="dropdown__menu" aria-hidden="true">
          <li><a href="#">English</a></li>
          <li><a href="#">Tiếng Việt</a></li>
        </ul>
      </div>
    </div>

    <div class="top-bar__right">
      <c:choose>
        <c:when test="${not empty sessionScope.userInSession}">
          <span class="welcome-text">Xin chào, ${sessionScope.userInSession.fullName}</span>
          <span class="divider-top">|</span>
          <a href="${pageContext.request.contextPath}/user/profile">Tài khoản</a>
          <span class="divider-top">|</span>
          <a href="${pageContext.request.contextPath}/logout" class="login">Đăng xuất</a>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}/login" class="login">Đăng nhập</a>
          <span class="divider-top">|</span>
          <a href="${pageContext.request.contextPath}/signup">Đăng ký</a>
        </c:otherwise>
      </c:choose>
    </div>
  </div>

  <div class="main-bar page-shell">
    <div class="main-bar__left">
      <a href="${pageContext.request.contextPath}/home" class="logo" aria-label="Trang chủ INOLA">
        <img src="${pageContext.request.contextPath}/assets/images/logo-inola.png" alt="INOLA logo">
      </a>
    </div>

    <form action="${pageContext.request.contextPath}/search" method="get" class="search-bar" role="search">
      <input type="text" name="keyword" placeholder="Tìm kiếm sản phẩm..." />
      <button class="search-btn" type="submit">
        <i class="fa-solid fa-magnifying-glass"></i>
      </button>
    </form>

    <a class="cart" href="${pageContext.request.contextPath}/cart" aria-label="Giỏ hàng">
      <i class="fa-solid fa-cart-shopping"></i>
      <span class="cart-badge" id="header-cart-count">
        <c:choose>
          <c:when test="${sessionScope.cart != null}">
            ${sessionScope.cart.totalQuantity()}
          </c:when>
          <c:otherwise>0</c:otherwise>
        </c:choose>
      </span>
    </a>
  </div>

  <nav class="nav-links page-shell" aria-label="Danh mục sản phẩm">
    <c:forEach var="c" items="${topCategories}">
      <a href="${pageContext.request.contextPath}/product-type?id=${c.id}">${c.category_name}</a>
    </c:forEach>
  </nav>
</header>

<script>
  document.addEventListener('DOMContentLoaded', () => {
    const trigger = document.querySelector('.dropdown__trigger');
    const menu = document.querySelector('.dropdown__menu');

    if (!trigger || !menu) {
      return;
    }

    trigger.addEventListener('click', (e) => {
      e.stopPropagation();
      const isOpen = menu.classList.toggle('open');
      trigger.setAttribute('aria-expanded', String(isOpen));
      menu.setAttribute('aria-hidden', String(!isOpen));
    });

    document.addEventListener('click', () => {
      menu.classList.remove('open');
      trigger.setAttribute('aria-expanded', 'false');
      menu.setAttribute('aria-hidden', 'true');
    });
  });
</script>