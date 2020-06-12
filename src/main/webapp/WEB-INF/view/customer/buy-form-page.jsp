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
            <td>
                Email(*):
            </td>
            <td>
                <form:input path="email" id="email"/>
            </td>
        </tr>

        <tr>
            <td>
                    ${dynamicForm.attractionNames[0]}
            </td>
            <td>
                <form:input path="tickets[0]" id="number"/>
            </td>
            <td>
                <c:url var="details0" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[0]}" />
                </c:url>
                <a href="${details0}" >Details</a>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[1]}
            </td>
            <td>
                <form:input path="tickets[1]" id="number"/>
            </td>
            <td>
                <c:url var="details1" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[1]}" />
                </c:url>
                <a href="${details1}" >Details</a>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[2]}
            </td>
            <td>
                <form:input path="tickets[2]" id="number"/>
            </td>

            <td>
                <c:url var="details2" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[2]}" />
                </c:url>
                <a href="${details2}" >Details</a>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[3]}
            </td>
            <td>
                <form:input path="tickets[3]" id="number"/>
            </td>
            <td>
                <c:url var="details3" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[3]}" />
                </c:url>
                <a href="${details3}" >Details</a>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[4]}
            </td>
            <td>
                <form:input path="tickets[4]" id="number"/>
            </td>
            <td>
                <c:url var="details4" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[4]}" />
                </c:url>
                <a href="${details4}" >Details</a>
            </td>
        </tr>
        <tr>
            <td>
                    ${dynamicForm.attractionNames[5]}
            </td>
            <td>
                <form:input path="tickets[5]" id="number"/>
            </td>
            <td>
                <c:url var="details5" value="/detailsAttraction" >
                    <c:param name="attractionName" value="${dynamicForm.attractionNames[5]}" />
                </c:url>
                <a href="${details5}" >Details</a>
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