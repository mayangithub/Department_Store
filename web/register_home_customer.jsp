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
    session.setAttribute("homecustomer", null);
    session.setAttribute("customerID", null);
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Register Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1><br>
        <div align="center">
            <form method="post" action="register_home_customer.jsp" class="form-horizontal" role="form">
                <div class="form-group">
                    <label >Email: </label>
                    <input type="email" id="email" name="email" placeholder="mail@domain.com" value="" class="form-control" required/><br><br>
                </div>
                <div class="form-group">
                    <label>Password: </label>
                    <input type="password" id="password" name="password" placeholder="Password" value="" class="form-control" required/><br><br>
                </div>
                <div class="form-group">
                    <label>Name: </label>
                    <input type="text" id="name" name="name" placeholder="Real Name" value="" required class="form-control"/><br><br>
                </div>
                <div class="form-group">
                    <label>Address: </label>
                    <input type="text" id="address" name="address" placeholder="Address" value="" required class="form-control"/><br><br>
                </div>
                <div class="form-group">
                    <label>Gender: &nbsp;</label>
                    <input type="radio" name='gender' value="Male" required class="radio-inline"> Male  
                    <input type='radio' name='gender' value="Female" required class="radio-inline"> Female<br><br>
                </div>
                <div class="form-group">
                    <label>Age: </label>
                    <input type='number' id='age' name="age" placeholder='Age' min="1" max="100" required class="form-control"/><br><br>
                </div>
                <div class="form-group">
                    <label>Marriage Status: &nbsp;</label>
                    <input type='radio' value='married' name="marriage" required class="radio-inline"> Married   
                    <input type='radio' name='marriage' value="single" required class="radio-inline"> Single<br><br>
                </div>
                <div class="form-group">
                    <label>Income: </label>
                    <input type='number' name="income" placeholder="Numeric Value" min="1" max="1000000000" required class="form-control"/><br><br>
                </div>
                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                <a href="login_home_customer.jsp">
                    <button class="btn btn-large" type="button">Existing Home Customer Login~</button>
                </a>
                
            </form>
            
        </div>
        
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
                            //response.sendRedirect("login_home_customer.jsp");
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
                            int customerID = security.findCustomerByEmail(email);
                            System.out.println(customerID);
                            HomeCustomer newHomeCustomer = new HomeCustomer(customerID, age, gender, marriage, income);
                            System.out.println(newHomeCustomer.getCustomerID());
                            System.out.println(newHomeCustomer.getAge());
                            session.setAttribute("homecustomer", newHomeCustomer);
                            session.setAttribute("customerID", customerID);
                            out.println("<script language='javascript'>alert('Congratulations! Registered successfully! Please Login~')</script>");
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
