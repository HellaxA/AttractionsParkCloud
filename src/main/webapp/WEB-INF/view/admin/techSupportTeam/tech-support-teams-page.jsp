<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tech Support Team Crud</title>
</head>
<body>
<table>
    <tr>
        <td>ID_team</td>
        <td>Specialization</td>
    </tr>
    <c:forEach var="techSupportTeam" items="${techSupportTeams}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteTechSupportTeam">
            <c:param name="idTeam" value="${techSupportTeam.idTeam}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateTechSupportTeam">
            <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            <c:param name="idTeam" value="${techSupportTeam.idTeam}"/>
        </c:url>
        <tr>
            <td>${techSupportTeam.idTeam}</td>
            <td>${techSupportTeam.specialization}</td>

            <td>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this tech support team?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <c:url var="addLink" value="/admin-login/admin-page/addNewTechSupportTeam">
                <c:param name="passwordValidator" value="${passwordValidator.password}"/>
            </c:url>
            <a href="${addLink}">Add Tech support team</a>
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
