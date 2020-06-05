<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/4/2020
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buy Ticket</title>
</head>
<body>
<form:form action="sendEmail" modelAttribute="customer" method="POST">
    <label>
        Email: <form:input path="email" /><br>
        <input type="submit" value="Send ticket">
    </label>
</form:form>
</body>
</html>
