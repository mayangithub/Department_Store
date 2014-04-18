<%-- 
    Document   : salesman_order
    Created on : Apr 14, 2014, 12:18:40 PM
    Author     : yanma
--%>

<%@page import="edu.pitt.store.Salesman"%>
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
                        <td><input type="number" required name="productID" placeholder="Product ID" /></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><input type="number" min="1" name="quantity" placeholder="Numeric Amount" required/></td>
                    </tr>
                    <tr>
                        <td>Customer ID</td>
                        <td><input type="number" required name="customerID" placeholder="Customer ID" /></td>
                    </tr>
                    <tr>
                        <td>Salesman ID</td>
                        <td><%=((Salesman) session.getAttribute("salesman")).getSalesID()%></td>
                    </tr>
                </table>
                <br>
                <input type="submit" value="Submit Order" />
            </form>
        </div>
        <br><br>
        <%
            if(session.getAttribute("salesman")!=null){
                if(request.getParameter("productID")!=null && request.getParameter("quantity")!=null && request.getParameter("customerID")!=null 
                        && session.getAttribute("salesman")!=null){
                    int productID = Integer.parseInt(request.getParameter("productID"));
                    Product product = new Product(productID);
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    if(product.getInventory()<quantity){
                        out.println("<script language='javascript'>alert('Inventory not enough.')</script>");
                    }else{
                        int customerID = Integer.parseInt(request.getParameter("customerID"));
                        int salesID = ((Salesman) session.getAttribute("salesman")).getSalesID();
                        session.setAttribute("salesID", salesID);
                        Salesman salesman = (Salesman) session.getAttribute("salesman");
                        salesman.placeOrder(salesID, productID, customerID, quantity);


                        out.println("<table border='2'  align = 'center' class='table table-striped, table table-hover'>");
                        out.println("<tr>");
                        out.println("<th>Purchase Option</th>");
                        out.println("<th>Enter</th>");
                        out.println("</tr><tr><td>Product ID</td>");
                        out.println("<td>"+productID+"</td></tr><tr>");
                        out.println("<td>Quantity</td><td>"+quantity+"</td></tr>");
                        out.println("<tr><td>Customer ID</td><td>"+customerID+"</td></tr><tr>");
                        out.println("<td>Salesman ID</td>");
                        out.println("<td>"+salesID+"</td></tr></table>");
                    }
                    
                    if(product.getInventory()<100){
                        out.println("<script language='javascript'>alert('Inventory less than 100.')</script>");
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
                
            
            <a href="salesman_action.jsp">
                <button class="btn btn-large" type="button">Back to Salesman Search Page~</button>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="login_salesman.jsp">
                <button class="btn btn-large" type="button">Back to Login Page~</button>
            </a>
                </div>
            <br><br>
            
            
            <br><br>



    </body>
</html>
