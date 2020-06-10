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
    <title>Add attraction</title>
</head>
<body>
<form action="/admin-login/admin-page/saveAttraction" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
        <tr>
            <td>
                ID_attraction
            </td>
            <td>
                <label>
                    <input name="ID_attraction"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Age Category</td>
            <td>
                <label>
                    <input name="age_category"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Duration</td>
            <td>
                <label>
                    <input name="duration"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Height</td>
            <td>
                <label>
                    <input name="height"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>ID_administrator</td>
            <td>
                <label>
                    <input name="ID_administrator"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>ID_support_team</td>
            <td>
                <label>
                    <input name="ID_support_team"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Name_of_attraction</td>
            <td>
                <label>
                    <input name="nameOfAttraction"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price_of_attraction</td>
            <td>
                <label>
                    <input name="priceOfAttraction"/>
                </label>
            </td>
        </tr>


        <input type="submit" value="Submit">
    </table>

</form>
</body>
</html>
