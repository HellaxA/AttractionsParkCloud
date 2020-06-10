<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Enter password</title>
</head>
<body>
    <form:form action="admin-page" modelAttribute="passwordValidator">
        Password: <form:password path="password" />
        <input type="submit" value="Login">
    </form:form>
</body>
</html>