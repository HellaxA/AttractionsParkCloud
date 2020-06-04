<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/4/2020
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<table>
    <tr>
        <th>idCustomer</th>
        <th>Tdate</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.idCustomer}</td>
            <td>${customer.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
