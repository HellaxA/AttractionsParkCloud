<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Tech support team</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<c:url var="techSupportTeamCRUD" value="/admin-login/admin-page/techSupportTeams" >
    <c:param name="passwordValidator" value="${passwordValidator.password}" />
</c:url>


<header class="w3-container w3-red w3-center" style="padding:32px 16px">
    <p class="w3-xlarge"><a href="${techSupportTeamCRUD}" >Tech support teams</a></p>
</header>
</body>
</html>
