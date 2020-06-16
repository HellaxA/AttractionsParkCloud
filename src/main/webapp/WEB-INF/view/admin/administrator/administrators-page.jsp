<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrators CRUD</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />

</head>
<body>
<table class="paleBlueRows" align="center">
    <tr>
        <th>ID_administrator</th>
        <th>Phone_number</th>
        <th>E_mail</th>
        <th>First_name</th>
        <th>Surname</th>
        <th>Middle_name</th>
        <th>Position</th>
        <th></th>
    </tr>
    <c:forEach var="admin" items="${administrators}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteAdministrator">
            <c:param name="idAdministrator" value="${admin.idAdministrator}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateAdministrator">
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            <c:param name="idAdministrator" value="${admin.idAdministrator}"/>
        </c:url>
        <tr>
            <td>${admin.idAdministrator}</td>
            <td>${admin.phoneNumber}</td>
            <td>${admin.email}</td>
            <td>${admin.firstName}</td>
            <td>${admin.surname}</td>
            <td>${admin.middleName}</td>
            <td>${admin.position}</td>
            <td>
                <a href="${updateLink}">Update</a>
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this admin?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8">
            <c:url var="addLink" value="/admin-login/admin-page/addNewAdmin">
                <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            </c:url>
            <a href="${addLink}">Add admin</a>
        </td>
    </tr>
    <tr>
        <td colspan="4">
            <p>
                <a href="${pageContext.request.contextPath}/admin-login/staff-only">Back to staff page</a>
            </p>
        </td>

        <td colspan="4">
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
    </tr>

</table>
</body>
</html>
