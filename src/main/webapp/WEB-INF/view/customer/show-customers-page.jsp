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
<table>
    <tr>
        <th>ID_attraction</th>
        <th>age_category</th>
        <th>duration</th>
        <th>height</th>
        <th>ID_administrator</th>
        <th>ID_support_team</th>
        <th>Name_of_attraction</th>
        <th>Price_of_attraction</th>
    </tr>
    <c:forEach var="attraction" items="${attractions}">
        <tr>
            <td>${attraction.idAttraction}</td>
            <td>${attraction.ageCategory}</td>
            <td>${attraction.duration}</td>
            <td>${attraction.height}</td>
            <td>${attraction.administrator}</td>
            <td>${attraction.techSupportTeam}</td>
            <td>${attraction.nameOfAttraction}</td>
            <td>${attraction.priceOfAttraction}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
