<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty p}">
    <div class="product-card">
        <a href="${pageContext.request.contextPath}/product?id=${p.id}">

            <div class="img-box">
                <img src="${p.image}" alt="${p.name}"/>

                <c:if test="${p.discountPercent != null}">
                    <span class="badge-sale">-${p.discountPercent}%</span>
                </c:if>
            </div>

            <p class="product-name">${p.name}</p>

            <div class="product-sold">
                Đã bán ${p.totalSold}
                <span class="rating">
                    <c:set var="fullStars" value="${Math.floor(p.avgRating)}" />
                    <c:set var="hasHalf" value="${p.avgRating - fullStars >= 0.5}" />
                
                    <c:forEach begin="1" end="${fullStars}">
                        <i class="fa-solid fa-star"></i>
                    </c:forEach>
                
                    <c:if test="${hasHalf}">
                        <i class="fa-solid fa-star-half-stroke"></i>
                    </c:if>
                
                    <c:forEach begin="1" end="${5 - fullStars - (hasHalf ? 1 : 0)}">
                        <i class="fa-regular fa-star"></i>
                    </c:forEach>
                
                    <c:if test="${p.reviewCount > 0}">
                        <span class="review-count">(${p.reviewCount})</span>
                    </c:if>
                </span>
            </div>

            <div class="price-container">
                <c:choose>
                    <c:when test="${p.discountPercent != null}">
                        <span class="old-price">
                            <fmt:formatNumber value="${p.originalPrice}" groupingUsed="true"/> ₫
                        </span>
                        <span class="current-price">
                            <fmt:formatNumber value="${p.discountedPrice}" groupingUsed="true"/> ₫
                        </span>
                    </c:when>

                    <c:otherwise>
                        <span class="current-price">
                            <fmt:formatNumber value="${p.originalPrice}" groupingUsed="true"/> ₫
                        </span>
                    </c:otherwise>
                </c:choose>
            </div>
        </a>
    </div>
</c:if>
