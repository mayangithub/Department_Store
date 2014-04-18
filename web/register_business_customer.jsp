<%-- 
    Document   : index
    Created on : Apr 12, 2014, 1:05:47 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.BusinessCustomer"%>
<%@page import="edu.pitt.store.Customer"%>
<%@page import="edu.pitt.store.Security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("businesscustomer", null);
    session.setAttribute("customerID", null);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Customer Register Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Welcome to INFSCI 2710 Department Store</h1>
        <div align="center">
            <form method="post" action="register_business_customer.jsp">
                <p>Email: 
                <input type="email" id="email" name="email" placeholder="mail@domain.com" required/></p><br>
                <p>Password: 
                <input type="password" id="password" name="password" placeholder="Password" required/></p><br>
                <p>Name: 
                <input type="text" id="name" name="name" placeholder="Real Name" required/></p><br>
                <p>Address: 
                <input type="text" id="address" name="address" placeholder="Address" required/></p><br>
                <p>Company Name: 
                <input name="companyName" type="text" placeholder="Company Name" required/></p><br>
                <p>Category: 
                <input type="text" name='category' placeholder="Company Category" required/></p><br>
                <label>Income: </label>
                <input type='number' name="income" placeholder="Numeric Value" min="100" max="100000000" required class='form-control'/> Thousand<br>

                <br>
                <button class="btn btn-large" type="submit" value="Submit">Submit</button>
                <button class="btn btn-large" type="reset" value="Reset">Reset</button>
                <a href="login_business_customer.jsp">
                        <button class="btn btn-large" type="button">Existing Business Customer Login~</button><p>

            </form>
        </div>
        
        <%
                String email = null;
                String password =null;
                String name = null;
                String address = null;
                String companyName = null;
                String category = null;
                int income = 0;
                

                    Security security = new Security();
                    
                     if(request.getParameter("email")!=null && request.getParameter("password")!=null && request.getParameter("name")!=null
                        &&request.getParameter("address")!=null && request.getParameter("companyName")!=null && request.getParameter("category")!=null
                        && request.getParameter("income")!=null ){
                        email = request.getParameter("email");
                        if(security.findExistingCustomer(email)){
                            out.println("<script language='javascript'>alert('You are already a customer. Please Login~')</script>");
                            
                        }else{
                            password = request.getParameter("password");
                            name = request.getParameter("name");
                            address = request.getParameter("address");
                            companyName = request.getParameter("companyName");
                            category = request.getParameter("category");
                            income = Integer.parseInt(request.getParameter("income"));

                            Customer newCustomer = new Customer(email, password, "Business", name, address);
                            int customerID = security.findCustomerByEmail(email);
                            System.out.println(customerID);
                            BusinessCustomer newBusinessCustomer = new BusinessCustomer(customerID, companyName, category, income);
                            System.out.println(newBusinessCustomer.getCustomerID());
                            System.out.println(newBusinessCustomer.getCategory());
                            session.setAttribute("businesscustomer", newBusinessCustomer);
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
