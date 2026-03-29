<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>
        <c:choose>
            <c:when test="${not empty pageTitle}">
                ${pageTitle}
            </c:when>
            <c:otherwise>
                INOLA
            </c:otherwise>
        </c:choose>
    </title>

    <link rel="icon"
          type="image/png"
          href="/assets/images/logo-inola.png">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/Base.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/header-renew.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/footer.css">

    <c:if test="${not empty pageCss}">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/assets/css/${pageCss}">
    </c:if>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>

<body>

<jsp:include page="/views/common/header-renew.jsp"/>

<main id="main-content">
    <jsp:include page="${contentPage}"/>
</main>

<jsp:include page="/views/common/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/common.js"></script>

<c:if test="${not empty pageJs}">
    <script src="${pageContext.request.contextPath}/assets/js/${pageJs}"></script>
</c:if>

</body>
</html>
