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
    <style type="text/css">
        * {
            font-family: cursive;
        }
    </style>
    <script type="text/javascript">
        function validateNumber()
        {
            let x=document.getElementById("number").value;
            if (isNaN(x))
            {
                alert("Must input numbers");
                return false;
            }
            return true;
        }

        function validateEmail(){
        let email = document.getElementById("email");
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value))
            {
                return true
            }
            alert("You have entered an invalid email address!")
            return false
        };
    </script>
</head>
<body>
<i>Fill out the form. Asterisk (*) means required.</i>

<form:form action="sendTicket" modelAttribute="dynamicForm" onsubmit="return validateNumber() && validateEmail()    ">
    <table>
        <tr>

        </tr>
        <tr>
            <td>
                Email(*):
            </td>
            <td>
                <form:input path="email" id="email"/>
            </td>
        </tr>

        <tr>
            <td>
                FerrisWheel:
            </td>
            <td>
                <form:input path="tickets[0]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                Trampouline:
            </td>
            <td>
                <form:input path="tickets[1]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                Giraffe Flying Chair:
            </td>
            <td>
                <form:input path="tickets[2]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                Viking pirate ship:
            </td>
            <td>
                <form:input path="tickets[3]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                Kids Pirate Ship Rides:
            </td>
            <td>
                <form:input path="tickets[4]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                Roller Coaster:
            </td>
            <td>
                <form:input path="tickets[5]" id="number"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
