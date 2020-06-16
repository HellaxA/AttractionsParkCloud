<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />
</head>
<body>
<table class="paleBlueRows" align="center">
    <tr>
        <th>ID_customer</th>
        <th>E-mail</th>
        <th>Date_of_attendance</th>
        <th></th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteCustomer">
            <c:param name="idCustomer" value="${customer.idCustomer}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateCustomer">
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            <c:param name="idCustomer" value="${customer.idCustomer}"/>
        </c:url>
        <tr>
            <td>${customer.idCustomer}</td>
            <td>${customer.email}</td>
            <td>${customer.date}</td>

            <td>
                <a href="${updateLink}">Update</a>
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <c:url var="addLink" value="/admin-login/admin-page/addNewCustomer">
                <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            </c:url>
            <a href="${addLink}">Add customer</a>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p>
                <a href="${pageContext.request.contextPath}/admin-login/staff-only">Back to staff page</a>
            </p>
        </td>

        <td colspan="2">
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
    </tr>
</table>
</body>
</html>
