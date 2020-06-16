<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
    </style>
    <title>Add attraction</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />
</head>
<body>
<form action="/admin-login/admin-page/saveAttraction" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table class="paleBlueRows" align="center">
        <tr>
            <td>
                ID_attraction
            </td>
            <td>
                <label>
                    <input name="ID_attraction" value="${attraction.idAttraction}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Age Category</td>
            <td>
                <label>
                    <input name="age_category" value="${attraction.ageCategory}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Duration</td>
            <td>
                <label>
                    <input name="duration" value="${attraction.duration}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Height</td>
            <td>
                <label>
                    <input name="height" value="${attraction.height}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>ID_administrator</td>
            <td>
                <label>
                    <input name="ID_administrator" value="${attraction.administrator.idAdministrator}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>ID_support_team</td>
            <td>
                <label>
                    <input name="ID_support_team" value="${attraction.techSupportTeam.idTeam}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Name_of_attraction</td>
            <td>
                <label>
                    <input name="nameOfAttraction" value="${attraction.nameOfAttraction}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price_of_attraction</td>
            <td>
                <label>
                    <input name="priceOfAttraction" value="${attraction.priceOfAttraction}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"
                       class="w3-button w3-black w3-padding-large w3-large w3-margin-top">
            </td>
        </tr>


    </table>

</form>
</body>
</html>
