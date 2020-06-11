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
</head>
<body>
<table>
    <tr>
        <td>ID_ticket</td>
        <td>Ticket_price</td>
        <td>Date_of_issuance</td>
        <td>ID_customer</td>
        <td>ID_ticket_terminal</td>
        <td>Access_Key</td>
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
            <td>${ticket.accessKey}</td>
            <td>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <c:url var="addLink" value="/admin-login/admin-page/addNewTicket" >
                <c:param name="passwordValidator" value="${passwordValidator.password}" />
            </c:url>
            <a href="${addLink}">Add ticket</a>
        </td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="${pageContext.request.contextPath}/admin-login/staff-only">Back to staff page</a>
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
    </tr>
</table>
</body>
</html>
