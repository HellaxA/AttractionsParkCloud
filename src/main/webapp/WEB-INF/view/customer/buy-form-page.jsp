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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
    </style>


    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/table.css" />
    <title>Buy Ticket</title>
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

<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-white">Buy</a>
    </div>
</div>

<header class="w3-container w3-red w3-center" style="padding:32px 16px">
    <p class="w3-xlarge"><i>Fill out the form. Asterisk (*) means required.</i></p>
</header>

<form:form action="sendTicket" modelAttribute="dynamicForm" onsubmit="return validateNumber() && validateEmail()    ">
    <table class="paleBlueRows" align="center">
        <tr>
            <th colspan="3">Form</th>
        </tr>
        <tr>
            <td>
                Email(*):
            </td>
            <td>
                <form:input path="email" id="email"/>
            </td>
            <td></td>
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
            <td colspan="3">
                <input type="submit" value="Submit"
                       class="w3-button w3-black w3-padding-large w3-large w3-margin-top">
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>