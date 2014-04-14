<%-- 
    Document   : manager_action
    Created on : Apr 13, 2014, 10:31:42 PM
    Author     : yanma
--%>

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
        </div>
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
        </div>
        
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
        <br><br><br><br><br><br>
    </body>
</html>
