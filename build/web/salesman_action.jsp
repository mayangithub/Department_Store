<%-- 
    Document   : salesman_action.jsp
    Created on : Apr 13, 2014, 10:05:17 PM
    Author     : yanma
--%>

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
        
        <h1 align="center">Search Product</h1>
        <div align="center">
            <form method="get" action="">
            <p>Product name:
                <input type="text" name="productName" placeholder="Product Name"/>（vague search）</p>
            <input type="submit" value="Submit Query" />
            </form>
        </div>
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
    </body>
</html>
