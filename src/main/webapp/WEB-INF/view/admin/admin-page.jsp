
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/10/2020
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CRUD</title>
</head>
<body>
    <c:url var="validme" value="/admin-login/admin-page/attractions" >
        <c:param name="password" value="${passwordValidator.password}"/>
    </c:url>

    <a href="${validme}" >Show attractions</a>


</body>
</html>
