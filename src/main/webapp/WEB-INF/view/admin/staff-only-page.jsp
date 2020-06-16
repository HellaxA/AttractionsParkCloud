<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Enter password</title>
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
</head>
<body>
    <header class="w3-container w3-red w3-center" style="padding:32px 16px">
        <form:form action="admin-page" modelAttribute="passwordValidator">
            <table align="center">
                <tr>
                    <td>Password: <form:password path="password"/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Login"
                               class="w3-button w3-black w3-padding-large w3-large w3-margin-top">
                    </td>
                </tr>
            </table>


        </form:form>
    </header>

</body>
</html>