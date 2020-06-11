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
</head>
<body>
<h3>Ticket has been sent to your email: ${email}</h3>

<table>
    <tr>
        <td>
            Name of attraction
        </td>
        <td>
            Times
        </td>
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
        Do not show this key to anybody! Save it, so that you can visit our attractions!
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
