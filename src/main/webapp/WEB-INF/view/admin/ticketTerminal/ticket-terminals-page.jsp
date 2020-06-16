<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Terminal CRUD</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />
</head>
<body>
<table class="paleBlueRows" align="center">
    <tr>
        <th>ID_ticket_terminal</th>
        <th>Payment_type</th>
        <th></th>

    </tr>
    <c:forEach var="ticketTerminal" items="${ticketTerminals}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteTicketTerminal">
            <c:param name="idTicketTerminal" value="${ticketTerminal.idTicketTerminal}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateTicketTerminal">
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
            <c:param name="idTicketTerminal" value="${ticketTerminal.idTicketTerminal}"/>
        </c:url>
        <tr>
            <td>${ticketTerminal.idTicketTerminal}</td>
            <td>${ticketTerminal.paymentType}</td>

            <td>
                <a href="${updateLink}">Update</a>
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this ticket terminal?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="9">
            <c:url var="addLink" value="/admin-login/admin-page/addNewTicketTerminal" >
                <c:param name="passwordValidator" value="${passwordValidator.password}" />
            </c:url>
            <a href="${addLink}">Add ticket terminal</a>
        </td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="${pageContext.request.contextPath}/admin-login/staff-only">Back to staff page</a>
            </p>
        </td>
        <td>
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
        <td></td>
    </tr>

</table>
</body>
</html>
