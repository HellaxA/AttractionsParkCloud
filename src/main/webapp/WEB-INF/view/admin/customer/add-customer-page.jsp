<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 6/11/2020
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer</title>
</head>
<body>
<form action="/admin-login/admin-page/saveCustomer" >
    <input type="hidden" name="passwordValidator" value="${passwordValidator.password}"/>
    <table>
        <tr>
            <td>
                Id Customer
            </td>
            <td>
                <label>
                    <input name="idCustomer" value="${customer.idCustomer}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td>
                <label>
                    <input name="email" value="${customer.email}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Date</td>
            <td>
                <label>
                    <input name="date" value="${customer.date}"/>
                </label>
            </td>
        </tr>



        <input type="submit" value="Submit">
    </table>

</form>
</body>
</html>
