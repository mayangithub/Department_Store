<%-- 
    Document   : index
    Created on : Apr 12, 2014, 1:05:47 PM
    Author     : yanma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Customer Register Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <div align="center">
            <form method="post" action="register_home_customer.jsp">
                <p>Email: 
                <input type="email" id="email" name="email" placeholder="mail@domain.com" /></p><br>
                <p>Password: 
                <input type="password" id="password" name="password" placeholder="Password" /></p><br>
                <p>Name: 
                <input type="text" id="name" name="name" placeholder="Real Name" /></p><br>
                <p>Address: 
                <input type="text" id="address" name="address" placeholder="Address" /></p><br>
                <p>Company Name: 
                <input name="companyName" type="text" placeholder="Company Name" /></p><br>
                <p>Category: 
                <input type="text" name='category' placeholder="Company Category" /></p><br>
                <p>Income: 
                <input type='text' name="income" placeholder="Numeric Value" /></p><br>

                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                <a href="login_business_customer.jsp">
                        <button class="btn btn-large" type="button">Existing Business Customer Login~</button><p>

            </form>
        </div>
    </body>
</html>
