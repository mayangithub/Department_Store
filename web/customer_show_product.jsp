<%-- 
    Document   : customer_show_product
    Created on : Apr 13, 2014, 11:17:19 PM
    Author     : yanma
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="edu.pitt.store.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(session.getAttribute("homecustomer")==null && session.getAttribute("businessCustomer")==null){
        response.sendRedirect("index.html");
    }else if(session.getAttribute("productList")==null){
        response.sendRedirect("home_customer_action.jsp");
    }
    
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer View Product Result</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Here is the Result</h1>
        <div align="center">
            <table class="table table-striped, table table-hover">
                <tr>
                    <th>Product ID</th>
                    <th>Product name</th>
                    <th>Category</th>
                    <th>Inventory</th>
                    <th>Price</th>
                </tr>
                <%
                    ArrayList<Product> matchedProductList = new ArrayList<Product>();
                    matchedProductList = (ArrayList<Product>)session.getAttribute("productList");
                    for(Product product: matchedProductList){
                        out.println("<tr>");
                        out.println("<td>"+product.getProductID()+"</td>");
                        out.println("<td>"+product.getName()+"</td>");
                        out.println("<td>"+product.getCategory()+"</td>");
                        out.println("<td>"+product.getInventory()+"</td>");
                        out.println("<td>"+product.getPrice()+"</td>");
                        out.println("</tr>");
                    }
                %>
                
            </table>
        </div>
    </body>
</html>
