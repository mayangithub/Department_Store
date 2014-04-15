<%-- 
    Document   : login_salesman
    Created on : Apr 12, 2014, 2:54:26 PM
    Author     : yanma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Login Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <h3>Your status is: <em>Salesman</em>.</h3>
        <div align="center">
            <form method="post" action="login_salesman.jsp">
                <p>Email: 
                <input type="email" id="username" name="username" placeholder="mail@domain.com" /></p><br>
                <p>Password: 
                <input type="password" id="password" name="password" placeholder="Password" /></p><br>

                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                

            </form>
            
            
        </div>
    </body>
</html>
