<!-- src/main/resources/templates/home.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="<spring:url value='/resources/css/style.css' />" />
</head>
<body>
    <div class="home-container">
        <h2>Welcome, <spring:eval expression="authentication.name" /></h2>
        <p>Your role: <spring:eval expression="authentication.authorities[0].authority" /></p>

        <c:choose>
            <c:when test="${authentication.authorities[0].authority == 'ROLE_ADMIN'}">
                <p>You have administrative privileges.</p>
            </c:when>
            <c:otherwise>
                <p>You have user privileges.</p>
            </c:otherwise>
        </c:choose>

        <a href="<spring:url value='/perform_logout' />" class="btn btn-secondary">Logout</a>
    </div>
</body>
</html>
