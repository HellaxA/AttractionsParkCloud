<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin-login/admin-page/saveTicketTerminal" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
        <tr>
            <td>
                Id Ticket Terminal
            </td>
            <td>
                <label>
                    <input name="idTicketTerminal" value="${ticketTerminal.idTicketTerminal}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Payment Type</td>
            <td>
                <label>
                    <input name="paymentType" value="${ticketTerminal.paymentType}"/>
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
