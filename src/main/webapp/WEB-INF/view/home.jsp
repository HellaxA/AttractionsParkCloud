<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td><a href="/showTickets">Show Tickets</a></td>
        <td><a href="/showCustomers">Show Customers</a></td>
    </tr>
</table>

<input type="button" value="Buy Ticket!"
       onclick="window.location.href='buyForm'; return false;"
       class="buyButton">
</body>
</html>