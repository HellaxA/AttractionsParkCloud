<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Tech Support Team</title>
</head>
<body>
<form action="/admin-login/admin-page/saveTechSupportTeam" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
        <tr>
            <td>
                ID team
            </td>
            <td>
                <label>
                    <input name="idTeam" value="${techSupportTeam.idTeam}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Specialization</td>
            <td>
                <label>
                    <input name="specialization" value="${techSupportTeam.specialization}"/>
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
