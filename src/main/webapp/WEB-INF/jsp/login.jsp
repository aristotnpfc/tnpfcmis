<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function validateForm() {
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;

            if (username == "" || password == "") {
                alert("Both Username and Password must be filled out");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Login</h2>

    <c:if test="${not empty error}">
        <div style="color:red">${error}</div>
    </c:if>

    <form name="loginForm" action="login" method="post" onsubmit="return validateForm()">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
