<%-- 
    Document   : login_manager
    Created on : Apr 12, 2014, 2:54:40 PM
    Author     : yanma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Login Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <h3>Your status is: <em>Manager</em>.</h3>
        <div align="center">
            <form method="post" action="login_manager.jsp">
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
