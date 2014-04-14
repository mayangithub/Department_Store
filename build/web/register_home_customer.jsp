<%-- 
    Document   : index
    Created on : Apr 12, 2014, 1:05:47 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.HomeCustomer"%>
<%@page import="edu.pitt.store.Customer"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
                String email = "";
                String password ="";
                String name = "";
                String address = "";
                String gender = "";
                String marriage = "";
                int age = 0;
                int income = 0;
                
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                    name = request.getParameter("name");
                    address = request.getParameter("address");
                    gender = request.getParameter("gender");
                    age = Integer.parseInt(request.getParameter("age").toString());
                    marriage = request.getParameter("marriage");
                    income = Integer.parseInt(request.getParameter("income").toString());

                    Security security = new Security();
                    if(security.findExistingCustomer(email)){
                        out.println("<script language='javascript'>alert('You are already a customer. Please Login~')</script>");
                        response.sendRedirect("login_home_customer.jsp");
                    }else{
                        Customer newCustomer = new Customer(email, password, "Home", name, address);
                        HomeCustomer newHomeCustomer = new HomeCustomer(newCustomer.getCustomerID(), age, gender, marriage, income);
                        out.println("<script language='javascript'>alert('Congratulations! Registered successfully! Please Login~')</script>");
                        response.sendRedirect("login_home_customer.jsp");
                    }
                
                
                
            %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Register Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1><br>
        <div align="center">
            <form method="post" action="register_home_customer.jsp">
                <p>Email: 
                    <input type="email" id="email" name="email" placeholder="mail@domain.com" value=""/></p><br>
                <p>Password:
                    <input type="password" id="password" name="password" placeholder="Password" value=""/></p><br>
                <p>Name:
                    <input type="text" id="name" name="name" placeholder="Real Name" value="" /></p><br>
                <p>Address: 
                    <input type="text" id="address" name="address" placeholder="Address" value=""/></p><br>
                <p>Gender: 
                    <input type="radio" name='gender' value="Male"> Male  
                    <input type='radio' name='gender' value="Female"> Female</p><br>
                <p>Age: 
                    <input type='text' id='age' name="age" placeholder='Age' value="0"/></p><br>
                <p>Marriage Status: 
                    <input type='radio' value='married' name="marriage"> Married   
                    <input type='radio' name='marriage' value="single"> Single</p><br>
                <p>Income: 
                    <input type='number' name="income" placeholder="Numeric Value" value=""/></p><br>

                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                <a href="login_home_customer.jsp">
                    <button class="btn btn-large" type="button">Existing Home Customer Login~</button>
                </a>
                
            </form>
            
        </div>
    </body>
</html>
