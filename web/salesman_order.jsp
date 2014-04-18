<%-- 
    Document   : salesman_order
    Created on : Apr 14, 2014, 12:18:40 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Order"%>
<%@page import="edu.pitt.store.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(session.getAttribute("salesman")==null){
        response.sendRedirect("login_salesman.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Order Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1 align="center">Salesman, You can make an order</h1>
        <div align="center" > 
            <form method="post" action="">
                <table border="2" class="table table-striped, table table-hover">
                    <tr>
                        <th>Purchase Option</th>
                        <th>Enter</th>
                    </tr>
                    <tr>
                        <td>Product ID</td>
                        <td><input type="text" value="" name="productID" placeholder="Product ID" /></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><input type="number" min="1" name="quantity" placeholder="Numeric Amount" /></td>
                    </tr>
                    <tr>
                        <td>Customer ID</td>
                        <td><input type="text" value="" name="customerID" placeholder="Customer ID" /></td>
                    </tr>
                    <tr>
                        <td>Salesman ID</td>
                        <td><input type="text" value="" name="salesmanID" placeholder="Salesman ID" /></td>
                    </tr>
                </table>
                <br>
                <input type="submit" value="Submit Order" />
            </form>
        </div>
        <%
            /*

                if (request.getParameter("quantity") != null && request.getParameter("customerID") != null) {
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    if (request.getParameter("productID") != null) {
                        int productID = Integer.parseInt(request.getParameter("productID"));
                        Product product = new Product(productID);
                        if (quantity < product.getInventory()) {
                            out.println("<script language='javascript'>alert('Inventory is less than your quantity. Please order less.')</script>");
                        } else {
                            int salesID = 20;
                            int customerID = Integer.parseInt(request.getParameter("customerID"));
                            Order order = new Order(customerID, salesID);
                            double price = product.getPrice();
                            double cost = product.getCost();
                            Order newOrder = new Order(order.getOrderID(), productID, quantity, price, cost);

                            out.println("<table align='center' border='2'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Product ID</th>");
                            out.println("<th>Quantity</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Price</th>");
                            out.println("<th>Cost</th>");
                            out.println("</tr>");

                            out.println("<tr>");
                            out.println("<td>" + order.getOrderID() + "</td>");
                            out.println("<td>" + product.getProductID() + "</td>");
                            out.println("<td>" + order.getQuantity() + "</td>");
                            out.println("<td>" + order.getCustomerID() + "</td>");
                            out.println("<td>" + order.getSalesID() + "</td>");
                            out.println("<td>" + newOrder.getPrice() + "</td>");
                            out.println("<td>" + newOrder.getCost() + "</td>");
                            out.println("</tr>");

                        }
                    }

                }

            }
                    
                    */

            
            
            
            
            
            
                    int quantity = 50;
                    int customerID = 163;
                    int productID = 75;
                        Product product = new Product(productID);
                        int inventory = product.getInventory();
                        out.println(inventory);
                        
                            out.println("<script language='javascript'>alert('Inventory is less than your quantity. Please order less.')</script>");
                         /*else {
                            int salesID = 20;
                            Order order = new Order(customerID, salesID);
                            double price = product.getPrice();
                            double cost = product.getCost();
                            Order newOrder = new Order(order.getOrderID(), productID, quantity, price, cost);

                            out.println("<table align='center' border='2'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Product ID</th>");
                            out.println("<th>Quantity</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Price</th>");
                            out.println("<th>Cost</th>");
                            out.println("</tr>");

                            out.println("<tr>");
                            out.println("<td>" + order.getOrderID() + "</td>");
                            out.println("<td>" + product.getProductID() + "</td>");
                            out.println("<td>" + order.getQuantity() + "</td>");
                            out.println("<td>" + order.getCustomerID() + "</td>");
                            out.println("<td>" + order.getSalesID() + "</td>");
                            out.println("<td>" + newOrder.getPrice() + "</td>");
                            out.println("<td>" + newOrder.getCost() + "</td>");
                            out.println("</tr>");

                        }
                                
                    }
*/
                

            

        %>
        <br>
        <br>
        <h1 align="center">Order Confirm</h1>


        <table border="2" class="table table-striped, table table-hover">
            <tr>
                <th>Purchase Option</th>
                <th>Enter</th>
            </tr>
            <tr>
                <td>Product ID</td>
                <td>48</td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td>3</td>
            </tr>
            <tr>
                <td>Customer ID</td>
                <td>2000</td>
            </tr>
            <tr>
                <td>Salesman ID</td>
                <td>10</td>
            </tr>
        </table>

        <%            out.println (
        "<script language='javascript'>alert('The inventory of this product is less than 100.')</script>");
        %>






    </body>
</html>
