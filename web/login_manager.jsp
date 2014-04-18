<%-- 
    Document   : login_manager
    Created on : Apr 12, 2014, 2:54:40 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Manager"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("manager", null);
    session.setAttribute("managerID", null);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Login Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <h3>Your status is: <em>Manager</em>.</h3>
        <div align="center">
            <form method="post" action="login_manager.jsp">
                <label>Email: &nbsp;</label>
                <input type="email" id="username" name="username" placeholder="mail@domain.com" required class="form-control"/><br><br>
                <label>Password: &nbsp;</label>
                <input type="password" id="password" name="password" placeholder="Password" required class="form-control"/><br><br>

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
                Manager manager = security.validateManagerLogin(email, password);
                if(manager!=null){
                    session.setAttribute("manager", manager);
                    int managerID = security.findManagerByEmail(email);
                    session.setAttribute("managerID", managerID);
                    out.println("<script language='javascript'>alert('Login successfully~')</script>");
                    response.sendRedirect("manager_action.jsp");
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
