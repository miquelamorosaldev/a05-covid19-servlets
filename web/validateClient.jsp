<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VALIDACIÓ COVID19 - RESTAURANT XINÈS TAN DAO VIEN</title>
        <link rel="STYLESHEET" href="./css/styles.css" TYPE="text/css">
    </head>
    <%
        // Si tenim algun error de validació el mostrem.
        String errorForm = (String) request.getAttribute("errorForm");
        errorForm = errorForm!=null?errorForm:"";
    %>
    <body>
        <h2>RESTAURANT XINÈS TAN DAO VIEN</h2>
        <p class='error'><%=errorForm %></p>
        <form method="post" action="ClientServlet">
            <label for="dni">DNI (*)
            <input type="text" required id='dni' name="dni" 
                   placeholder='12345678Z'> 
            </input>
            <!--        
            <label for="condicions">He llegit y acepto las condicions</label>
            <input type="checkbox" name="condicions" value="selected" />
            -->
            <input type="submit" name="ok" value="validate"/>
        </form> 
    </body>
    <footer>
        <p>RESTAURANT XINÈS TAN DAO VIEN, CC-BY-SA</p>
    </footer>
</html>
