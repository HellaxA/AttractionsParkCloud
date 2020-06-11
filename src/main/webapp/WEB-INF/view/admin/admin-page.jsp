
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
    <c:url var="attractionsCRUD" value="/admin-login/admin-page/attractions" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${attractionsCRUD}" >Attractions</a>

    <c:url var="administratorCRUD" value="/admin-login/admin-page/administrators" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${administratorCRUD}" >Administrators</a>


    <c:url var="ticketTerminalCRUD" value="/admin-login/admin-page/ticketTerminals" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${ticketTerminalCRUD}" >Ticket Terminals</a>

    <c:url var="customerCRUD" value="/admin-login/admin-page/customers" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${customerCRUD}" >Customers</a>

    <c:url var="techSupportTeamCRUD" value="/admin-login/admin-page/techSupportTeams" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${techSupportTeamCRUD}" >Tech Support Teams</a>

    <c:url var="ticketCRUD" value="/admin-login/admin-page/tickets" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <a href="${ticketCRUD}" >Tickets</a>

</body>
</html>
