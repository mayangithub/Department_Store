<%-- 
    Document   : home_customer_action
    Created on : Apr 13, 2014, 7:02:52 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Order"%>
<%@page import="edu.pitt.store.Customer"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="edu.pitt.utilities.DbUtilities"%>
<%@page import="edu.pitt.store.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.pitt.store.HomeCustomer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(session.getAttribute("homecustomer")==null){
        response.sendRedirect("login_home_customer.jsp");
    }
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Operation Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body >
        <h1 align="center">Welcome! For Home Customer:</h1>
        <h3 align="center">Browse product</h3>
    <!---------------Browse Products by Category ---------------------->
        <div align="center">
            <form method="get" action="home_customer_action.jsp" >
                <label>Category of Products: &nbsp;</label>
                <select name="category" class="form-control" >
                    
                    <option value="all" selected="selected">All</option>
                    <option value="Men's Clothing">Men's Clothing</option>
                    <option value="Women's Clothing">Women's Clothing</option>
                    <option value="kids Clothing">Kids Clothing</option>
                    <option value="Handbags">Handbags</option>
                    <option value="Shoes">Shoes</option>
                </select><br><br>
                    <input type="submit" value="Submit Query" class="btn btn-default"/>
            </form>
            
        </div>
        <br>
        <%
            
            
            HomeCustomer homeCustomer = (HomeCustomer) session.getAttribute("homehustomer");
            if(request.getParameter("category")!=null){
                String category = request.getParameter("category");
                int customerID = Integer.parseInt(session.getAttribute("customerID").toString());
                System.out.println(customerID);
                Customer customer = new Customer(customerID);
                ArrayList<Product> productList = customer.customerFindProductByCategory(category);
                out.println("<table align='center' border='2' class='table table-hover'>");
                out.println("<tr>");
                out.println("<th> Product ID </th>");   
                out.println("<th> Product name </th>");
                out.println("<th> Category </th>");
                out.println("<th> Inventory </th>");
                out.println("<th> Price </th>");
                out.println("</tr>");

                for(Product product: productList){
                    out.println("<tr>");
                    out.println("<td> "+product.getProductID()+" </td>");
                    out.println("<td> "+product.getName()+" </td>");
                    out.println("<td> "+product.getCategory()+" </td>");
                    out.println("<td> "+product.getInventory()+" </td>");
                    out.println("<td> "+product.getPrice()+" </td>");
                    out.println("</tr>");
                }

                out.println("</table>");


            }
            
        %>
        <br><br>
    <!---------------Browse Products by Product Name ---------------------->    
        <h3 align="center">Search Product</h3>
        <div align="center">
            <form method="get" action="home_customer_action.jsp">
                <label>Product name: &nbsp;
                    <input type="text" name="productName" placeholder="Product Name" class="form-control" size="100" required/>（vague search）</label><br><br>
            <input type="submit" value="Submit Query" class="btn btn-default"/>
            </form>
        </div>
        <br>
        
        <%
            homeCustomer = (HomeCustomer) session.getAttribute("homecustomer");
            if(request.getParameter("productName")!=null){
                String name = request.getParameter("productName");
                ArrayList<Product> productList = homeCustomer.findProductByName(name);
                out.println("<table align='center' border='2'  class='table table-hover'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("</tr>");
                
                for(Product product: productList){
                    out.println("<tr>");
                    out.println("<td>"+product.getProductID()+"</td>");
                    out.println("<td>"+product.getName()+"</td>");
                    out.println("<td>"+product.getCategory()+"</td>");
                    out.println("<td>"+product.getInventory()+"</td>");
                    out.println("<td>"+product.getPrice()+"</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
                
            }
            
        %>
        <br><br>
        
    <!---------------Browse Products by Product ID ---------------------->    
        <h3 align="center">Search Product</h3>
        <div align="center">
            <form method="get" action="home_customer_action.jsp">
                <label>Product ID: &nbsp;
                    <input type="number" name="productID" placeholder="Product ID" size="120" class="form-control" required/>（precise search） </label><br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
            
        </div>
        <br>
        <%
            if(request.getParameter("productID")!=null){
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = new Product(productID);
                
                out.println("<table align='center' border='2' class='table table-hover'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("</tr>");
                
                
                if(product.getProductID()!=0){
                    out.println("<tr>");
                    out.println("<td>"+product.getProductID()+"</td>");
                    out.println("<td>"+product.getName()+"</td>");
                    out.println("<td>"+product.getCategory()+"</td>");
                    out.println("<td>"+product.getInventory()+"</td>");
                    out.println("<td>"+product.getPrice()+"</td>");
                    out.println("</tr>");
                }
                
                
            
            out.println("</table>");
            
            }
            
        %>
    
        <br><br>
        <h1 align="center">Search for Orders</h1>
        <div align="center">
            <a href="home_customer_searchorder.jsp">
                <button class="btn btn-large" type="button">Search your order history~</button>
            </a>
        </div>
        
        <br><br>
        <div align="center">
            <a href="index.html">
                <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>
        </div>
        <br><br>
    </body>
</html>
