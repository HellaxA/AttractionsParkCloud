<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Customer</title>
</head>
<body>
<c:url var="customerCRUD" value="/admin-login/admin-page/customers" >
    <c:param name="passwordValidator" value="${passwordValidator.password}" />
</c:url>
<a href="${customerCRUD}" >Customers</a>
</body>
</html>
