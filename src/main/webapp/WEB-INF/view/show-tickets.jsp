<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/4/2020
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all tickets</title>
</head>
<body>

<table>
    <tr>
        <th>Id ticket</th>
        <th>Ticket price</th>
        <th>Date</th>
        <th>Id customer</th>
        <th>Id ticket terminal</th>
        <th>Time</th>
    </tr>
    <c:forEach var="ticket" items="${tickets}">
        <tr>
            <td>${ticket.idTicket}</td>
            <td>${ticket.ticketPrice}</td>
            <td>${ticket.dateOfIssuance}</td>
            <td>${ticket.customer}</td>
            <td>${ticket.ticketTerminal}</td>
            <td>${ticket.timeOfIssuance}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
