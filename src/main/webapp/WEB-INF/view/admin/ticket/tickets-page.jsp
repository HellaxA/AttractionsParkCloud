<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets CRUD</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />
</head>
<body>
<table class="paleBlueRows" align="center">
    <tr>
        <th>ID_ticket</th>
        <th>Ticket_price</th>
        <th>Date_of_issuance</th>
        <th>ID_customer</th>
        <th>ID_ticket_terminal</th>
        <th></th>
    </tr>
    <c:forEach var="ticket" items="${tickets}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteTicket">
            <c:param name="idTicket" value="${ticket.idTicket}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateTicket">
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
            <c:param name="idTicket" value="${ticket.idTicket}"/>
        </c:url>
        <tr>
            <td>${ticket.idTicket}</td>
            <td>${ticket.ticketPrice}</td>
            <td>${ticket.dateOfIssuance}</td>
            <td>${ticket.customer.idCustomer}</td>
            <td>${ticket.ticketTerminal.idTicketTerminal}</td>
            <td>
                <a href="${updateLink}">Update</a>
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <c:url var="addLink" value="/admin-login/admin-page/addNewTicket" >
                <c:param name="passwordValidator" value="${passwordValidator.password}" />
            </c:url>
            <a href="${addLink}">Add ticket</a>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <p>
                <a href="${pageContext.request.contextPath}/admin-login/staff-only">Back to staff page</a>
            </p>
        </td>

        <td colspan="3">
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
    </tr>
</table>
</body>
</html>
