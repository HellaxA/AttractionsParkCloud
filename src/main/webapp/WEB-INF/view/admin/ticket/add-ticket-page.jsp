<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Ticket</title>
</head>
<body>
<form action="/admin-login/admin-page/saveTicket" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
        <tr>
            <td>
                Id Ticket
            </td>
            <td>
                <label>
                    <input name="idTicket" value="${ticket.idTicket}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Date Of Issuance</td>
            <td>
                <label>
                    <input name="dateOfIssuance" value="${ticket.dateOfIssuance}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Ticket Price</td>
            <td>
                <label>
                    <input name="ticketPrice" value="${ticket.ticketPrice}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Access Key</td>
            <td>
                <label>
                    <input name="accessKey" value="${ticket.accessKey}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Id Ticket Terminal</td>
            <td>
                <label>
                    <input name="idTicketTerminal" value="${ticket.ticketTerminal.idTicketTerminal}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Id Customer</td>
            <td>
                <label>
                    <input name="idCustomer" value="${ticket.customer.idCustomer}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
