<%-- 
    Document   : register_result_home_customer
    Created on : Apr 14, 2014, 1:34:31 AM
    Author     : yanma
--%>

<%@page import="edu.pitt.utilities.StringUtilities"%>
<%@page import="edu.pitt.store.HomeCustomer"%>
<%@page import="edu.pitt.store.Customer"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Result for Home Customer</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <%
                String email = null;
                String password =null;
                String name = null;
                String address = null;
                String gender = null;
                String marriage = null;
                int age = 0;
                int income = 0;
                

                    Security security = new Security();
                    
                     if(request.getParameter("email")!=null && request.getParameter("password")!=null && request.getParameter("name")!=null
                        &&request.getParameter("address")!=null && request.getParameter("gender")!=null && request.getParameter("age")!=null
                        &&request.getParameter("marriage")!=null && request.getParameter("income")!=null ){
                        email = request.getParameter("email");
                        if(security.findExistingCustomer(email)){
                            out.println("<script language='javascript'>alert('You are already a customer. Please Login~')</script>");
                        }else{
                        password = request.getParameter("password");
                        name = request.getParameter("name");
                        address = request.getParameter("address");
                        gender = request.getParameter("gender");
                        if(request.getParameter("age").equals("")){
                            age=1;
                        }else{
                            age = Integer.parseInt(request.getParameter("age"));
                        }
                        
                        marriage = request.getParameter("marriage");
                        if(request.getParameter("income").equals("")){
                            income=1;
                        }else{
                            income = Integer.parseInt(request.getParameter("income"));
                        }
                        
                        Customer newCustomer = new Customer(email, password, "Home", name, address);
                        HomeCustomer newHomeCustomer = new HomeCustomer(newCustomer.getCustomerID(), age, gender, marriage, income);
                        out.println("<script language='javascript'>alert('Congratulations! Registered successfully! Please Login~')</script>");
                        }
                    }else {
                        out.println("<script language='javascript'>alert('Please fill in all blanks~')</script>");
                    }
                
                
                
            %>
    </body>
</html>
