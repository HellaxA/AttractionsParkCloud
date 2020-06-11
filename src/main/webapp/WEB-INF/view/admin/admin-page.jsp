
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
    <c:url var="administratorCRUD" value="/admin-login/admin-page/administrators" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>

    <c:url var="ticketTerminalCRUD" value="/admin-login/admin-page/ticketTerminals" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <c:url var="customerCRUD" value="/admin-login/admin-page/customers" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <c:url var="techSupportTeamCRUD" value="/admin-login/admin-page/techSupportTeams" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>
    <c:url var="ticketCRUD" value="/admin-login/admin-page/tickets" >
        <c:param name="passwordValidator" value="${passwordValidator.password}" />
    </c:url>

<table>
    <tr>
        <td>
            <a href="${attractionsCRUD}" >Attractions</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${administratorCRUD}" >Administrators</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${ticketTerminalCRUD}" >Ticket Terminals</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${customerCRUD}" >Customers</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${techSupportTeamCRUD}" >Tech Support Teams</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${ticketCRUD}" >Tickets</a>
        </td>
    </tr>

</table>

</body>
</html>
