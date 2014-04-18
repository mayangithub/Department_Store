<%-- 
    Document   : home_customer_searchorder
    Created on : Apr 17, 2014, 6:33:28 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.pitt.store.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("homecustomer")==null){
        response.sendRedirect("login_home_customer.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Search Orders</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1>Welcome! For Home Customer:</h1>
        <!---------------Search Orders by Time Period, Product ID, or Order ID ---------------------->
        <h3 align="center">Search for Orders</h3>
        <div align="center">
            <form method="get" action="home_customer_searchorder.jsp" >
                <label>Time period: </label>
                <select name="timePeriod" class="form-control">
                    <option value="1000" selected="selected"> All Orders </option>
                    <option value="30"> Last 30 Days </option>
                    <option value="60"> Last 60 Days </option>
                    <option value="90"> Last 90 Days </option>
                </select><br><br>
                <label>Product ID: 
                    <input name="productID" type="number" placeholder="Product ID" value="0" required/></label><br><br>
                <label>Order ID: 
                    <input type="text" name="orderID" placeholder="Order ID"  value="0" required/></label><br><br>
                <input type="submit" value="Submit Query" class="btn btn-default" />
                
            </form>
        </div><br>
        <%
                int period = 1000;
                int productID = 0;
                int orderID = 0;
                if(session.getAttribute("customerID")!=null){
                    int customerID = Integer.parseInt(session.getAttribute("customerID").toString());
                    System.out.println("customerID: "+customerID);
                    if(customerID!=0){
                        Customer customer = new Customer(customerID);
                        ArrayList<Order> orderList = new ArrayList<Order>();
                            if(request.getParameter("orderID")!=null ){
                                orderID = Integer.parseInt(request.getParameter("orderID"));
                                System.out.println("orderID: "+orderID);
                            }
                            if(request.getParameter("timePeriod")!=null){
                                period = Integer.parseInt(request.getParameter("timePeriod"));
                                System.out.println("Period: "+period);
                            }
                            if(request.getParameter("productID")!=null){
                                productID = Integer.parseInt(request.getParameter("productID"));
                                System.out.println("productID"+productID);
                            }
                                
                            

                        if(customer.customerFindOrder(customerID, period, productID, orderID)!=null){
                            orderList = customer.customerFindOrder(customerID, period, productID, orderID);

                            out.println("<table align='center' border='2'  class='table table-hover'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Order Date</th>");
                            out.println("<th>Product ID</th>");   
                            out.println("<th>Price</th>");
                            out.println("<th>Quantity</th>");
                            out.println("</tr>");

                            for(Order order: orderList){
                                out.println("<tr>");
                                out.println("<td>"+order.getOrderID()+"</td>");
                                out.println("<td>"+order.getCustomerID()+"</td>");
                                out.println("<td>"+order.getSalesID()+"</td>");
                                out.println("<td>"+order.getDate()+"</td>");
                                out.println("<td>"+order.getProductID()+"</td>");
                                out.println("<td>"+order.getPrice()+"</td>");
                                out.println("<td>"+order.getQuantity()+"</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        }
                    }
                }
                
           
            
        %>
        
        
        <br><br>
        <div align="center">
            <a href="index.html">
                <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="login_home_customer.jsp">
                        <button class="btn btn-large" type="button">Back to Login Page~</button>
            </a>
        </div>
        <br><br>
        
    </body>
</html>
