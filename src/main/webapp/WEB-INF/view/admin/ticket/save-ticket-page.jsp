<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Ticket</title>
</head>
<body>
<c:url var="ticketsCRUD" value="/admin-login/admin-page/tickets" >
    <c:param name="passwordValidator" value="${passwordValidator.password}" />
</c:url>
<a href="${ticketsCRUD}" >Tickets</a>
</body>
</html>
