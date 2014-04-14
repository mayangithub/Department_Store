<%-- 
    Document   : salesman_action.jsp
    Created on : Apr 13, 2014, 10:05:17 PM
    Author     : yanma
--%>

<%@page import="java.util.Date"%>
<%@page import="edu.pitt.store.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="edu.pitt.utilities.DbUtilities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Operation Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Browse product</h1>
        <div align="center">
            <p>Category of Products: </p>
                <form method="get" action="">
                    <select name="category">
                        <option value="Men's Clothing">Men's Clothing</option>
                        <option value="Women's Clothing">Women's Clothing</option>
                        <option value="kids Clothing">Kids Clothing</option>
                        <option value="Handbags">Handbags</option>
                        <option value="Shoes">Shoes</option>
                    </select>
                    <input type="submit" value="Submit Query" />
                </form>
            
        </div>
        <br><br>
        <%
             String sql = "select * from department_store.product where category = 'Handbags'";
            DbUtilities db = new DbUtilities();
            ResultSet rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
        
        
        %>
        
        <br><br>
        
        <h1 align="center">Search Product</h1>
        <div align="center">
            <form method="get" action="">
            <p>Product name:
                <input type="text" name="productName" placeholder="Product Name"/>（vague search）</p>
            <input type="submit" value="Submit Query" />
            </form>
        </div>
        <br><br>
        <%
            sql = "select * from department_store.product where name like '%b%'";;
            rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
            
        
        
        %>
        <br><br>
        
        <h1 align="center">Search Product</h1>
        <div align="center">
            <form method="get" action="">
                <p>Product ID: 
                <input type="text" value="" name="productID" placeholder="Product ID" /></p>
                <input type="submit" value="Submit Query"  />
            </form>
            
        </div>
        <br><br>
        <br>
        <%
            if(request.getParameter("productID")!=null){
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = new Product(productID);
                out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            
            out.println("</table>");
            
            }
            
        %>
        <br><br>
        
        <h1 align="center">Search for Orders</h1>
        <div align="center">
            <form method="get" action="" >
                <p>Time period: 
                <select name="timePeriod">
                    <option value="30">30 Days</option>
                    <option value="60">60 Days</option>
                    <option value="90">90 Days</option>
                    <option value="1000"> All </option>
                </select></p>
                <p>Product ID: 
                    <input value="" name="productID" type="text" placeholder="Product ID"/></p>
                <p>Order ID: 
                    <input type="text" name="orderID" value="" placeholder="Order ID" /></p>
                <p>Customer ID: 
                    <input type="text" name="customerID" value="" placeholder="Customer ID" /></p>
                <input type="submit" value="Submit Query" />
                
            </form>
        </div>
        <br><br><br>
        <%
            int salesID = 25;
            int period = 1000;
            sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID,"
                    + " order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.salesID = " + salesID + " "
                    + "and date BETWEEN SYSDATE() - INTERVAL " + period + " DAY AND SYSDATE() "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Order ID</th>");  
                out.println("<th>Salesman ID</th>");
                out.println("<th>Customer ID</th>");
                out.println("<th>Order Date</th>");
                out.println("<th>Product ID</th>");
                out.println("<th>Quantity</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                
                out.println("</tr>");
            while(rs.next()){
                int orderID = rs.getInt("order_ID");
                int customerID = rs.getInt("customer_ID");
                Date date = rs.getDate("order_date");
                int productID = rs.getInt("product_ID");
                double price = rs.getDouble("price");
                double cost = rs.getDouble("cost");
                int quantity = rs.getInt("quantity");
                out.println("<tr>");
                out.println("<td>"+orderID+"</td>");
                out.println("<td>"+salesID+"</td>");
                out.println("<th>"+customerID+"</th>");
                out.println("<td>"+date+"</td>");
                out.println("<td>"+productID+"</td>");
                out.println("<td>"+quantity+"</td>");
                out.println("<td>"+price+"</td>");
                out.println("<td>"+cost+"</td>");
                
                out.println("</tr>");
                
                
            }
            out.println("</table>");
            
            
        %>
        <br><br><br><br><br><br><br>
    </body>
</html>
