<%-- 
    Document   : login_salesman
    Created on : Apr 12, 2014, 2:54:26 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Salesman"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("salesman", null);
    session.setAttribute("salesID", null);
%>
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
                <input type="email" id="username" name="username" placeholder="mail@domain.com" required/></p><br>
                <p>Password: 
                    <input type="password" id="password" name="password" placeholder="Password" required /></p><br>

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
                Salesman salesman = security.validateSalesmanLogin(email, password);
                if(salesman!=null){
                    session.setAttribute("salesman", salesman);
                    int salesID = security.findSalesmanByEmail(email);
                    session.setAttribute("salesID", salesID);
                    out.println("<script language='javascript'>alert('Login successfully~')</script>");
                    response.sendRedirect("salesman_action.jsp");
                }else{
                    out.println("<script language='javascript'>alert('Login failed.')</script>");
                }
            }
        
        
        
        
        %>
        
            <br><br>
            <div align="center">
            <a href="index.html">
                <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>
            </div>
            
            <br><br>
        
        
    </body>
</html>
