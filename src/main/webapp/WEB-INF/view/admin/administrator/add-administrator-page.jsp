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
    <title>Add administrator</title>
</head>
<body>
<form action="/admin-login/admin-page/saveAdministrator" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
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
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
