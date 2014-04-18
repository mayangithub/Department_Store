<%-- 
    Document   : login_business_customer
    Created on : Apr 12, 2014, 2:54:56 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.BusinessCustomer"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("businesscustomer")!=null){
        response.sendRedirect("business_customer_action.jsp?");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Customer Login Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <h3>Your status is: <em>Business Customer</em>.</h3>
        <div align="center">
            <form method="post" action="login_business_customer.jsp">
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
            session.setAttribute("businesscustomer", null);
            session.setAttribute("customerID", null);
            if(request.getParameter("username")!=null && request.getParameter("password")!=null){
                email = request.getParameter("username");
                password = request.getParameter("password");
                Security security = new Security();
                BusinessCustomer businessCustomer = security.validateBusinessCustomerLogin(email, password);
                if(businessCustomer!=null){
                    session.setAttribute("businessCustomer", businessCustomer);
                    int customerID = security.findCustomerByEmail(email);
                    session.setAttribute("customerID", customerID);
                    out.println("<script language='javascript'>alert('Login successfully~')</script>");
                    response.sendRedirect("business_customer_action.jsp");
                }else{
                    out.println("<script language='javascript'>alert('Login failed.')</script>");
                }
            }
        %>
            <br><br>
            <div align="center">
            <a href="index.html">
                <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="register_business_customer.jsp">
                <button class="btn btn-large" type="button">Register First~</button>
            </a>
            </div>
            
            <br><br>
        
    </body>
</html>
