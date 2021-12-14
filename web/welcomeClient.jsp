<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VALIDACIÓ COVID19 - RESTAURANT XINÈS TAN DAO VIEN</title>
        <link rel="STYLESHEET" href="./css/estil.css" TYPE="text/css">
    </head>
    <body>
        <h2>
    <%
        String userDNI = (String) request.getAttribute("userDNI");
        if(userDNI!=null) {
    %> 
            <%=userDNI %>
            WELCOME TO RESTAURANT XINÈS TAN DAO VIEN INTRANET
    <% } else { 
        out.println("Error!Not allowed Access!");
    }%>
    </h2>
    </body>
    <footer>
        <p>RESTAURANT XINÈS TAN DAO VIEN, CC-BY-SA</p>
    </footer>
</html>
