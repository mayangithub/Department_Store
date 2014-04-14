<%-- 
    Document   : login_home_customer
    Created on : Apr 12, 2014, 1:51:28 PM
    Author     : yanma
--%>

<%@page import="javax.jms.Session"%>
<%@page import="edu.pitt.store.HomeCustomer"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Login Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <h3>Your status is: <em>Home Customer</em>.</h3>
        <div align="center">
            <form method="post" action="login_home_customer.jsp">
                <p>Email: 
                <input type="email" id="username" name="username" placeholder="mail@domain.com" /></p><br>
                <p>Password: 
                <input type="password" id="password" name="password" placeholder="Password" /></p><br>

                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                

            </form>
            
            
        </div>
        <%
            String email = "";
            String password = "";
            if(request.getParameter("username")!=null && request.getParameter("password")!=null){
                email = request.getParameter("username");
                password = request.getParameter("password");
                Security security = new Security();
                HomeCustomer homeCustomer = security.validateHomeCustomerLogin(email, password);
                if(homeCustomer!=null){
                    session.setAttribute("homecustomer", homeCustomer);
                    out.println("<script language='javascript'>alert('Login successfully~')</script>");
                    response.sendRedirect("home_customer_action.jsp");
                }else{
                    out.println("<script language='javascript'>alert('Login failed.')</script>");
                }
            }
        %>
    </body>
</html>
