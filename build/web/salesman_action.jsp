<%-- 
    Document   : salesman_action.jsp
    Created on : Apr 13, 2014, 10:05:17 PM
    Author     : yanma
--%>

<%@page import="java.awt.datatransfer.SystemFlavorMap"%>
<%@page import="edu.pitt.store.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.pitt.store.Salesman"%>
<%@page import="java.util.Date"%>
<%@page import="edu.pitt.store.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="edu.pitt.utilities.DbUtilities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("salesman")==null){
        response.sendRedirect("login_salesman.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Operation Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1>Welcome! For salesman: </h1>
        <!---------------Browse Products by Category ---------------------->
        <h1 align="center">Browse product</h1>
        <div align="center">
            <form method="post" action="salesman_action.jsp">
            <label>Category of Products: &nbsp;</label>
                
            <select name="category" class="form-control" required>
                        <option value="all" selected="selected">All</option>
                        <option value="Men's Clothing">Men's Clothing</option>
                        <option value="Women's Clothing">Women's Clothing</option>
                        <option value="kids Clothing">Kids Clothing</option>
                        <option value="Handbags">Handbags</option>
                        <option value="Shoes">Shoes</option>
                    </select><br><br>
            <input type="submit" value="Submit Query" class="btn btn-default" />
                </form>
            
        </div>
        <br><br>
        <%
            Salesman salesman =(Salesman) session.getAttribute("salesman");
            if(request.getParameter("category")!=null){
                String category = request.getParameter("category");
                int salesID = Integer.parseInt(session.getAttribute("salesID").toString());
                System.out.println(salesID);
                salesman = new Salesman(salesID);
                ArrayList<Product> productList = salesman.findProductByCategory(category);
                out.println("<table align='center' border='2' class='table table-hover'>");
                out.println("<tr>");
                out.println("<th> Product ID </th>");   
                out.println("<th> Product name </th>");
                out.println("<th> Category </th>");
                out.println("<th> Inventory </th>");
                out.println("<th> Price </th>");
                out.println("<th> Cost </th>");
                out.println("</tr>");

                for(Product product: productList){
                    out.println("<tr>");
                    out.println("<td> "+product.getProductID()+" </td>");
                    out.println("<td> "+product.getName()+" </td>");
                    out.println("<td> "+product.getCategory()+" </td>");
                    out.println("<td> "+product.getInventory()+" </td>");
                    out.println("<td> "+product.getPrice()+" </td>");
                    out.println("<td> "+product.getCost()+" </td>");
                    out.println("</tr>");
                }

                out.println("</table>");


            }
        
        %>
        
        <br><br>
        <!---------------Browse Products by Product Name ---------------------->    
        <h1 align="center">Search Product By Product Name</h1>
        <div align="center">
            <form method="get" action="salesman_action.jsp">
                <label>Product name: &nbsp; </label>
            <input type="text" name="productName" placeholder="Product Name" class="form-control"/>（vague search）<br><br>
            <input type="submit" value="Submit Query" class="btn btn-default"/>
            </form>
        </div>
        <br><br>
        <%
            salesman = (Salesman) session.getAttribute("salesman");
            if(request.getParameter("productName")!=null){
                String name = request.getParameter("productName");
                ArrayList<Product> productList = salesman.findProductByName(name);
                out.println("<table align='center' border='2'  class='table table-hover'>");
                out.println("<tr>");
                out.println("<th> Product ID </th>");   
                out.println("<th> Product name </th>");
                out.println("<th> Category </th>");
                out.println("<th> Inventory </th>");
                out.println("<th> Price </th>");
                out.println("<th> Cost </th>");
                out.println("</tr>");
                
                for(Product product: productList){
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
                
            }
            
        %>
        <br><br>
        <!--------------- Browse Products by Product ID ----------------------> 
        <h1 align="center">Search Product By Product ID</h1>
        <div align="center">
            <form method="post" action="salesman_action.jsp">
                <label>Product ID: &nbsp;</label>
                <input type="number"  name="productID" placeholder="Product ID" size="120" required class="form-control"/>（precise search） <br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
            
        </div>
        <br><br>
        <br>
        <%
            if(request.getParameter("productID")!=null){
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = new Product(productID);
                
                out.println("<table align='center' border='2'  class='table table-hover'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
                if(product != null){


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
                }
           
            
            
        %>
        <br><br>
        <!---------------Search Orders by Time Period, Product ID, or Order ID , and only for own orders---------------------->
        <h1 align="center">Search for Orders</h1>
        <div align="center">
            <form method="post" action="salesman_action.jsp" >
                <label>Time period: </label>
                <select name="timePPeriod" class="form-control" required>
                    <option value="1000" selected="selected"> All Orders </option>
                    <option value="30"> Last 30 Days </option>
                    <option value="60"> Last 60 Days </option>
                    <option value="90"> Last 90 Days </option>
                </select><br><br>
                <label>Product ID: </label>
                <input  name="productIID" type="number" value="0" placeholder="Product ID" class="form-control"/><br><br>
                <label>Order ID: </label>
                <input type="number" name="orderIID"  value = "0" placeholder="Order ID" class="form-control"/><br><br>
                <label>Customer ID: </label>
                <input type="number" name="customerIID" value="0" placeholder="Customer ID" class="form-control"/><br><br>
                <input type="submit" value="Submit Query" class="btn btn-default"/>
                
            </form>
        </div>
        <br><br><br>
        <%
            int period = 1000;
            int productID = 0;
            int orderID = 0;
            int customerID = 0;
            if(session.getAttribute("salesID")!=null){
                int salesID = Integer.parseInt(session.getAttribute("salesID").toString());
                System.out.println(salesID);
                    if(salesID!=0){
                        salesman = new Salesman(salesID);
                        ArrayList<Order> orderList = new ArrayList<Order>();
                        
                        if(request.getParameter("orderIID")!=null){
                            orderID = Integer.parseInt(request.getParameter("orderIID"));
                            System.out.println("orderID: "+orderID);
                        }
                        if(request.getParameter("timePPeriod")!=null){
                                period = Integer.parseInt(request.getParameter("timePPeriod"));
                                System.out.println("Period: "+period);
                        }
                        if(request.getParameter("productIID")!=null){
                                productID = Integer.parseInt(request.getParameter("productIID"));
                                System.out.println("productID"+productID);
                        }
                        if(request.getParameter("customerIID")!=null){
                            customerID = Integer.parseInt(request.getParameter("customerIID"));
                            System.out.println("customerID"+customerID);
                        }
                        
                    if(orderID!=0){
                        if(salesman.salesFindOrderByOrderID(salesID, orderID)!=null){
                            orderList = salesman.salesFindOrderByOrderID(salesID, orderID);
                        }
                    }else if(period!=0){
                        if(productID!=0 && customerID!=0){
                            if(salesman.salesFindOrderByCustomerProductID(salesID, customerID, productID, period)!=null){
                                orderList = salesman.salesFindOrderByCustomerProductID(salesID, customerID, productID, period);
                            }
                        }else if(productID != 0 && customerID ==0){
                            if(salesman.salesFindOrderByProductID(salesID, productID, period)!=null){
                                orderList = salesman.salesFindOrderByProductID(salesID, productID, period);
                            }
                        }else if(productID ==0 && customerID!=0){
                            if(salesman.salesFindOrderByCustomerID(salesID, customerID, period)!=null){
                                orderList = salesman.salesFindOrderByCustomerID(salesID, customerID, period);
                            }
                        }else{
                            if(salesman.salesFindOrderByDatePeriod(salesID, period)!=null){
                                orderList = salesman.salesFindOrderByDatePeriod(salesID, period);
                            }
                        }
                    }
                    System.out.println("customerID"+customerID);
                    System.out.println("salesID"+salesID);
                    System.out.println("produID"+productID);
                    System.out.println("period"+period);
                    System.out.println("orderID"+orderID);
                    out.println("<table align='center' border='2'  class='table table-hover'>");
                    out.println("<tr>");
                    out.println("<th> Order ID </th>");
                    out.println("<th> Customer ID </th>");
                    out.println("<th> Salesman ID </th>");
                    out.println("<th> Order Date </th>");
                    out.println("<th> Product ID </th>");  
                    out.println("<th> Quantity </th>");
                    out.println("<th> Price </th>");
                    out.println("<th> Cost </th>");
                    out.println("</tr>");
                    if(orderList!=null){
                        for(Order order: orderList){
                            out.println("<tr>");
                            out.println("<td>"+order.getOrderID()+"</td>");
                            out.println("<td>"+order.getCustomerID()+"</td>");
                            out.println("<td>"+order.getSalesID()+"</td>");
                            out.println("<td>"+order.getDate()+"</td>");
                            out.println("<td>"+order.getProductID()+"</td>");
                            out.println("<td>"+order.getQuantity()+"</td>");
                            out.println("<td>"+order.getPrice()+"</td>");
                            out.println("<td>"+order.getCost()+"</td>");
                            out.println("</tr>");
                        }
                    }
                    
                    out.println("</table>");
                    
                }    
                    
            }
            
        %>
        <br><br><br>
        
        <h1 align="center">Make an Order</h1>
        <div align="center">
            <a href="salesman_order.jsp">
                        <button class="btn btn-large" type="button">Salesman, you can order here~</button>
            </a>
        </div>
        <br><br>
        
        <div align="center">
            <a href="index.html">
                        <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="login_salesman.jsp">
                        <button class="btn btn-large" type="button">Back to Login Page~</button>
            </a>
            
        </div>
        
        <br><br><br><br><br>
    </body>
</html>
