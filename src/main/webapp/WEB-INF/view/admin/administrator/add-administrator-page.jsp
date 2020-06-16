<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 4:26 PM
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
    <title>Add administrator</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table-admin.css" />
</head>
<body>
<form action="/admin-login/admin-page/saveAdministrator" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table class="paleBlueRows" align="center">
        <tr>
            <td>
                Id Administrator
            </td>
            <td>
                <label>
                    <input name="idAdministrator" value="${administrator.idAdministrator}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>
                <label>
                    <input name="phoneNumber" value="${administrator.phoneNumber}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Position</td>
            <td>
                <label>
                    <input name="position" value="${administrator.position}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>First Name</td>
            <td>
                <label>
                    <input name="firstName" value="${administrator.firstName}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Middle Name</td>
            <td>
                <label>
                    <input name="middleName" value="${administrator.middleName}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Surname</td>
            <td>
                <label>
                    <input name="surname" value="${administrator.surname}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td>
                <label>
                    <input name="email" value="${administrator.email}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <label>
                    <input name="password" value="${administrator.password}"/>
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
