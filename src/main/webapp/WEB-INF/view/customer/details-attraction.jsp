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
    <title>Details Ferris Wheel</title>
</head>
<body>

Attraction info:<br>
Name of attraction: ${attraction.nameOfAttraction}<br>
Age category:       ${attraction.ageCategory} <br>
Duration:           ${attraction.duration}<br>
Height:             ${attraction.height}m<br>
Price:              ${attraction.priceOfAttraction}$<br>

<br><br>

Admin info:<br>
First name:      ${attraction.administrator.firstName}<br>
Middle name:     ${attraction.administrator.middleName}<br>
Surname:         ${attraction.administrator.surname}<br>
Email:           ${attraction.administrator.email}<br>
Phone Number:    ${attraction.administrator.phoneNumber}<br>
</body>
</html>
