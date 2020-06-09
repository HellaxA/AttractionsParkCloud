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
                Email:
            </td>
            <td>
                <form:input path="email" id="email" onchange="validateNumber()"/>
            </td>
        </tr>

        <tr>
            <td>
                    ${dynamicForm.attractionNames[0]}
            </td>
            <td>
                <form:input path="tickets[0]" onchange="validateNumber()"/>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[1]}
            </td>
            <td>
                <form:input path="tickets[1]" onchange="validateNumber()"/>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[2]}
            </td>
            <td>
                <form:input path="tickets[2]" onchange="validateNumber()"/>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[3]}
            </td>
            <td>
                <form:input path="tickets[3]" onchange="validateNumber()"/>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[4]}
            </td>
            <td>
                <form:input path="tickets[4]" onchange="validateNumber()"/>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[5]}
            </td>
            <td>
                <form:input path="tickets[5]" onchange="validateNumber()"/>
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