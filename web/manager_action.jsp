<%-- 
    Document   : manager_action
    Created on : Apr 13, 2014, 10:31:42 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Manager"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="edu.pitt.utilities.DbUtilities"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="edu.pitt.store.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Operation Page</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Update Product Inventory</h1>
        <div align="center">
            <form method="post" action="">
                <p>Product ID: <input type="text" value="" name="productID" placeholder="Product ID" /></p>
                <p>Inventory Amount: <input type="text" value="" name="inventory" placeholder="Numeric Amount"/></p>
                <input type="submit" value="Submit Query"  />
            </form>
        </div>
        <br>
        
        <br><br>
        <h1 align="center">Add New Product</h1>
        <div align="center">
            <form method="post" action="">
                <p>Name: <input type="text" value="" placeholder="Product Name" name="name" /></p>
                <p>Category: 
                <select name="category">
                        <option value="Men's Clothing">Men's Clothing</option>
                        <option value="Women's Clothing">Women's Clothing</option>
                        <option value="kids Clothing">Kids Clothing</option>
                        <option value="Handbags">Handbags</option>
                        <option value="Shoes">Shoes</option>
                </select></p>
                <p>Inventory: <input type="text" value="" name="inventory" placeholder="Numeric Number" /></p>
                <p>Price: <input type="text" name="price" value="" placeholder="Price" /></p>
                <p>Cost: <input type="text" name="cost" value="" placeholder="Cost" /></p>
                <input type="submit" value="Submit Query"  />
            </form>
        </div><br>
        <table align='center' border='2'>
                <tr>
                    <th>Product ID</th>
                    <th>Product name</th>
                    <th>Category</th>
                    <th>Inventory</th>
                    <th>Price</th>
                            <th>Cost</th>
                </tr>
        <%
        
                
                  
                        out.println("<tr>");
                        out.println("<td>101</td>");
                        out.println("<td>Queen Dress</td>");
                        out.println("<td>kids Clothing</td>");
                        out.println("<td>110</td>");
                        out.println("<td>30</td>");
                        out.println("<td>25</td>");
                        out.println("</tr>");
                    
               
                
            
            
        %>
        </table>
        <br><br>
        <h1 align="center">Aggregation View For Manager</h1>
        <div align="center">
            <form method="get" action="">
                <p>Category of Customer: 
                    <select name="customer">
                        <option value="home_customer">Home Customer</option>
                        <option value="business_customer">Business Customer</option>
                    </select>
                </p>
                <p>Time Period: 
                    <select name="timePeriod">
                        <option value="30">30 Days</option>
                        <option value="60">60 Days</option>
                        <option value="90">90 Days</option>
                        <option value="1000"> All </option>
                    </select>
                </p>
                <p>Top Numbers:
                    <select name="top">
                        <option value="10">10</option>
                        <option value="all">All</option>
                    </select>
                </p>
                <p>Order By: 
                    <select name="orderBy">
                        <option value="profit">Profit</option>
                        <option value="total">Total</option>
                        <option value="quantity">Quantity</option>
                    </select>
                </p>
                <p>Aggregation By: </p>
                <input type="radio" value="order_detail.productID"> Product 
                <input type="radio" value="product.category"> Category 
                <input type="radio" value="stores.regionID"> Region 
                <input type="radio" value="salesman.storeID"> Store 
                <input type="radio" value="orders.salesID"> Salesman
                <input type="radio" value="orders.customerID"> Customer
                <br><br>
                <input type="submit" value="Submit Query" />
            </form>
        </div><br>
        <table align="center" border='2'>
            <tr>
                <th>Salesman ID</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Profit</th>
            </tr> 
            <%
                        DbUtilities db = new DbUtilities();
                        
              String sql = "select orders.salesID,"+
                        " sum(quantity) as quantity, "+
                        "sum(order_detail.price*order_detail.quantity) as total, "+
                        "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                        "from department_store.order_detail, department_store.orders, department_store.salesman, "+
                        "department_store.customer, department_store.store, department_store.product "+
                        "where orders.orderID = order_detail.orderID "+
                        "and orders.salesID = salesman.salesID "+
                        "and orders.customerID = customer.customerID "+
                        "and salesman.storeID = store.storeID "+
                        "and order_detail.productID = product.productID "+
                        "and customer.kind = 'Home' "+
                        "and orders.date BETWEEN SYSDATE() - INTERVAL 60 DAY AND SYSDATE() "+
                        "group by salesID "+
                        "order by profit DESC "+
                        "limit 0,10";
                try{
                ResultSet rs = db.getResultSet(sql);
                while(rs.next()){
                    
                        int salesID = rs.getInt("orders.salesID");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                        out.println("<tr>");
                        out.println("<td>"+salesID+"</td>");
                        out.println("<td>"+quantity+"</td>");
                        out.println("<td>"+total+"</td>");
                        out.println("<td>"+profit+"</td>");
                        out.println("</tr>");
                }
                }catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
            %>
            
            
            
            
        </table>
        
        
        <br><br>
        
        <h1 align="center">View Top Customer for Specific Product</h1>
        <div align="center">
            <form method="get" action="">
                <p>Category of Customer: 
                    <select name="customer">
                        <option value="home_customer">Home Customer</option>
                        <option value="business_customer">Business Customer</option>
                    </select>
                </p>
                <p>Time Period: 
                    <select name="timePeriod">
                        <option value="30">30 Days</option>
                        <option value="60">60 Days</option>
                        <option value="90">90 Days</option>
                        <option value="1000"> All </option>
                    </select>
                </p>
                <p>Order By: 
                    <select name="orderBy">
                        <option value="profit">Profit</option>
                        <option value="total">Total</option>
                        <option value="quantity">Quantity</option>
                    </select>
                </p>
                <p>Product Name: <input value="" name="productName" type="text" placeholder="Product Name" /> (Precise Query)</p>
                <input type="submit" value="Submit Query" />
            </form>
        </div>
        <br><br>
        
        <table border='2' align="center">
            <tr>
                <th>Customer ID</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Profit</th>
            </tr>
            
           <%
               
            //where customer.kind=customerCategory and product.name=productName
            //Order by orderCondition
            sql = "select orders.customerID, "+
                    "sum(quantity) as quantity, "+
                    "sum(order_detail.price*order_detail.quantity) as total, "+
                    "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                    "from department_store.order_detail, department_store.orders, "+
                    "department_store.customer, department_store.product "+
                    "where orders.orderID = order_detail.orderID "+
                    "and orders.customerID = customer.customerID "+
                    "and order_detail.productID = product.productID "+
                    "and product.name = 'nycc' "+
                    "and customer.kind = 'Home' "+
                    "and orders.date BETWEEN SYSDATE() - INTERVAL 90 DAY AND SYSDATE() "+
                    "group by orders.customerID "+
                    "order by total DESC";
            
            ResultSet rs = db.getResultSet(sql);
            try{
            while(rs.next()){
                int customerID = rs.getInt("orders.customerID");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                double profit = rs.getDouble("profit");
                
                out.println("<tr>");
                out.println("<td>"+customerID+"</td>");
                out.println("<td>"+quantity+"</td>");
                out.println("<td>"+total+"</td>");
                out.println("<td>"+profit+"</td>");
                out.println("</tr>");
            }
            } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
           
           
           %>
            
            
            
        </table>
        
        
        <br><br><br><br>
    </body>
</html>
