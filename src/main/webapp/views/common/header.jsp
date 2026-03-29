<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="header-wrapper">
            <header class="header-container page-container">

                <div class="user-bar">
                    <div class="right">
                        <c:choose>
                            <c:when test="${not empty sessionScope.userInSession}">
                                <div class="user-box" id="userToggle">
                                    <span class="user-name">
                                        Xin chào, ${sessionScope.userInSession.fullName}
                                    </span>
                                    <i class="fa fa-caret-down"></i>
                                </div>

                                <div class="user-dropdown" id="userDropdown">
                                    <a href="${pageContext.request.contextPath}/user/profile">
                                        <i class="fa fa-user"></i> Tài khoản
                                    </a>
                                    <a href="${pageContext.request.contextPath}/user/orders">
                                        <i class="fa fa-receipt"></i> Đơn hàng
                                    </a>
                                    <a href="${pageContext.request.contextPath}/user/review">
                                        <i class="fa fa-star"></i> Đánh giá
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a href="${pageContext.request.contextPath}/logout" class="logout">
                                        <i class="fa fa-sign-out-alt"></i> Đăng xuất
                                    </a>
                                </div>
                            </c:when>

                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                                <span>|</span>
                                <a href="${pageContext.request.contextPath}/signup">Đăng ký</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="main-header">

                    <div class="dropdown-menu" id="dropdownMenu">
                        <c:forEach var="c" items="${categories}">
                            <a href="${pageContext.request.contextPath}/product-type?id=${c.id}">
                                ${c.name}
                            </a>
                        </c:forEach>
                    </div>

                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/home">
                            <img src="${pageContext.request.contextPath}/assets/images/logo-inola.png"
                                style="height: 60px; width: auto; object-fit: contain" ;>
                        </a>
                    </div>

                    <div class="center">
                        <form action="${pageContext.request.contextPath}/search" method="get" class="search-wrapper"
                            style="position: relative;">

                            <input type="text" name="keyword" class="search-bar" placeholder="Tìm kiếm sản phẩm...">

                            <button type="submit" class="search-btn">
                                <i class="fa fa-search"></i>
                            </button>
                        </form>
                    </div>

                    <a href="${pageContext.request.contextPath}/cart" class="icon-btn cart-btn">
                        <i class="fa-solid fa-cart-shopping"></i> <span class="cart-badge" id="header-cart-count">
                            <c:choose>
                                <c:when test="${sessionScope.cart != null}">
                                    ${sessionScope.cart.totalQuantity()}
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                        </span>
                    </a>

                </div>

                <c:if test="${headerMode == null || headerMode == 'MENU'}">
                    <nav class="menu-bar">
                        <c:forEach var="c" items="${topCategories}">
                            <c:choose>

                                <c:when test="${headerMode == 'MENU'}">
                                    <a href="#Loai${c.id}">
                                        ${c.name}
                                    </a>
                                </c:when>

                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/home#Loai${c.id}">
                                        ${c.name}
                                    </a>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>
                    </nav>
                </c:if>

                <c:if test="${headerMode == 'BREADCRUMB'}">
                    <div class="breadcrumb">

                        <a href="${pageContext.request.contextPath}/home">
                            Trang chủ
                        </a>

                        <span>›</span>

                        <c:if test="${not empty breadcrumbCategory}">
                            <a href="${pageContext.request.contextPath}/category?id=${breadcrumbCategory.id}">
                                ${breadcrumbCategory.name}
                            </a>
                        </c:if>

                        <c:if test="${not empty breadcrumbProduct}">
                            <span>›</span>
                            <span class="current">
                                ${breadcrumbProduct.name}
                            </span>
                        </c:if>

                    </div>
                </c:if>

            </header>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', () => {

                const menuBtn = document.getElementById('menuBtn');
                const dropdownMenu = document.getElementById('dropdownMenu');
                const overlay = document.getElementById('headerOverlay');
                const userToggle = document.getElementById('userToggle');
                const userDropdown = document.getElementById('userDropdown');

                function closeAll() {
                    dropdownMenu?.classList.remove('open');
                    userDropdown?.classList.remove('open');
                    userDropdown?.classList.remove('show');
                    overlay?.classList.remove('active');

                    if (menuBtn) menuBtn.setAttribute('aria-expanded', 'false');
                }
                if (menuBtn) {
                    menuBtn.addEventListener('click', (e) => {
                        e.preventDefault(); e.stopPropagation();
                        const isOpen = dropdownMenu.classList.toggle('open');
                        overlay?.classList.toggle('active', isOpen);
                        userDropdown?.classList.remove('open');
                        userDropdown?.classList.remove('show');
                    });
                }
                if (userToggle) {
                    userToggle.addEventListener('click', (e) => {
                        e.preventDefault(); // Chặn thẻ a hoặc div click mặc định
                        e.stopPropagation(); // Không cho sự kiện lan ra ngoài

                        const isOpen = userDropdown.classList.toggle('open');
                        userDropdown.classList.toggle('show');
                        overlay?.classList.toggle('active', isOpen);

                        dropdownMenu?.classList.remove('open');
                    });
                }
                document.addEventListener('click', (e) => {
                    // Nếu click không trúng menu hay nút toggle thì đóng hết
                    if (!dropdownMenu?.contains(e.target) &&
                        !menuBtn?.contains(e.target) &&
                        !userDropdown?.contains(e.target) &&
                        !userToggle?.contains(e.target)) {
                        closeAll();
                    }
                });

                document.querySelectorAll('.dropdown-menu a').forEach(link => {
                    link.addEventListener('click', () => closeAll());
                });

                document.querySelectorAll('.user-dropdown a').forEach(link => {
                    link.addEventListener('click', (e) => {
                        e.stopPropagation();
                        closeAll();


                        console.log("Navigating to: " + link.getAttribute('href'));
                    });
                });

            });

            function updateHeaderCartCount(newCount) {
                const badge = document.getElementById('header-cart-count');
                if (badge) {
                    badge.innerText = newCount;

                    // Hiệu ứng nháy nhẹ để người dùng chú ý
                    badge.style.transform = "scale(1.2)";
                    setTimeout(() => {
                        badge.style.transform = "scale(1)";
                    }, 200);
                }
            }
        </script>

        <c:if test="${enableHeaderOverlay}">
            <div id="headerOverlay" class="overlay"></div>
        </c:if>

        <script src="${pageContext.request.contextPath}/assets/js/SearchAutocomplete.js"></script>