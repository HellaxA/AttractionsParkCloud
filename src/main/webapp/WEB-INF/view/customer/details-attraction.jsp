<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/12/2020
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table.css" />
    <title>Buy Ticket</title>
    <title>Details Ferris Wheel</title>
</head>
<body>
<table class="paleBlueRows" align="center">
    <tr>
        <th>Attraction info:</th>
    </tr>
    <tr>
        <td>Name of attraction: ${attraction.nameOfAttraction}</td>
    </tr>
    <tr>
        <td>Age category:       ${attraction.ageCategory}</td>
    </tr>
    <tr>
        <td>Duration:           ${attraction.duration}</td>
    </tr>
    <tr>
        <td>Height:             ${attraction.height}m</td>
    </tr>
    <tr>
        <td>Price:              ${attraction.priceOfAttraction}$</td>
    </tr>

</table>
<br><br>

<table class="paleBlueRows" align="center">
    <tr>
        <th>Admin info:</th>
    </tr>
    <tr>
        <td>First name:      ${attraction.administrator.firstName}</td>
    </tr>
    <tr>
        <td>
            Middle name:     ${attraction.administrator.middleName}</td>
    </tr>
    <tr>
        <td>Surname:         ${attraction.administrator.surname}</td>
    </tr>
    <tr>
        <td>
            Email:           ${attraction.administrator.email}</td>
    </tr>
    <tr>
        <td>Phone Number:    ${attraction.administrator.phoneNumber}<br></td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="${pageContext.request.contextPath}/buyForm">Back to BUY</a>
            </p>
        </td>
    </tr>
</table>
</body>
</html>
