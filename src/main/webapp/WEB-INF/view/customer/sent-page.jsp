<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/5/2020
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email has been sent</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table.css" />
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
</head>
<body>
<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-white">Confirmation</a>
    </div>
</div>

<header class="w3-container w3-red w3-center" style="padding:32px 16px">
    <p class="w3-xlarge">Ticket has been sent to your email: ${email}</p>
</header>

<table class="paleBlueRows" align="center">
    <tr>
        <th>
            Name of attraction
        </th>
        <th>
            Times
        </th>
    </tr>
    <c:forEach var="attraction" items="${attractions}">
        <tr>
            <td>
                    ${attraction.key.nameOfAttraction}
            </td>
            <td>
                    ${attraction.value}
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td>
            Total price:
        </td>
        <td>
            ${ticket.ticketPrice}
        </td>
    </tr>
    <tr>
        <td>
            Ticket unique key:
        </td>
        <td>
            ${ticket.accessKey}
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p>
                <a href="${pageContext.request.contextPath}/home">Back to home</a>
            </p>
        </td>
    </tr>
</table>

<header class="w3-container w3-red w3-center" style="padding:32px 16px">
    <p class="w3-xlarge"><i>Do not show this key to anybody! Save it, so that you can visit our attractions!</i></p>
</header>
</body>
</html>
