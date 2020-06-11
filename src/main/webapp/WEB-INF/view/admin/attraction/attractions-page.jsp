<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/10/2020
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Attractions CRUD</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Age category</td>
        <td>Duration</td>
        <td>Height</td>
        <td>Administrator email</td>
        <td>Tech Support Team id</td>
        <td>Name Of Attraction</td>
        <td>Price Of Attraction</td>
    </tr>
    <c:forEach var="attraction" items="${attractions}">
        <c:url var="deleteLink" value="/admin-login/admin-page/deleteAttraction">
            <c:param name="attractionId" value="${attraction.idAttraction}"/>
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
        </c:url>
        <c:url var="updateLink" value="/admin-login/admin-page/formUpdateAttraction">
            <c:param name="passwordValidator" value="${passwordValidator.password}" />
            <c:param name="attractionName" value="${attraction.nameOfAttraction}"/>
        </c:url>
        <tr>
            <td>${attraction.idAttraction}</td>
            <td>${attraction.ageCategory}</td>
            <td>${attraction.duration}</td>
            <td>${attraction.height}</td>
            <td>${attraction.administrator.email}</td>
            <td>${attraction.techSupportTeam.idTeam}</td>
            <td>${attraction.nameOfAttraction}</td>
            <td>${attraction.priceOfAttraction}</td>
            <td>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this attraction?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <c:url var="addLink" value="/admin-login/admin-page/addNewAttraction" >
                <c:param name="passwordValidator" value="${passwordValidator.password}" />
            </c:url>
            <a href="${addLink}">Add attraction</a>
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
