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
<%
    if(session.getAttribute("manager")==null){
        response.sendRedirect("login_manager.jsp");
    }


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Operation Page</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-theme.min.css">
    </head>
    <body>
        <h1>Welcome! For Manager:</h1>
        <!-------------------Update Product Inventory-------------------------------->
        <h1 align="center">Update Product Inventory</h1>
        <div align="center">
            <form method="post" action="manager_action.jsp">
                <label>Product ID: &nbsp;</label><input type="number" class="form-control" min="1"  size="50" name="productID" placeholder="Product ID" required/><br><br>
                <label>Inventory Amount: &nbsp;</label><input type="number" class="form-control" name="inventory" placeholder="Numeric Amount" required/><br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
        </div>
        <%
            if(session.getAttribute("manager")!=null){
                if(session.getAttribute("managerID")!=null){
                    int managerID = Integer.parseInt(session.getAttribute("managerID").toString());
                    Manager manager = new Manager(managerID);
                    System.out.println(managerID);
                    if(request.getParameter("productID")!=null && request.getParameter("productID")!=null){
                        int productID = Integer.parseInt(request.getParameter("productID"));
                        int inventory = Integer.parseInt(request.getParameter("inventory"));
                        System.out.println(productID);
                        if(manager.findProductByProductID(productID)==null){
                            out.println("<script language='javascript'>alert('Product doesn't exist! Please add it first!')</script>");
                        }else{
                            
                            manager.updateInventory(productID, inventory);
                            Product product = new Product(productID);
                            productID = product.getProductID();
                        
                            inventory = product.getInventory();
                            System.out.println(productID);
                            System.out.println(inventory);
                            out.println("<script language='javascript'>alert('Update Inventory Successfully!  ProductID: "+productID+"   Inventory: "+inventory+"')</script>");
                            if(inventory<100){
                                out.println("<script language='javascript'>alert('Inventory less than 100!')</script>"); 
                            }
                        }
                    }
                        
                }
            }
        
        %>
        
        <br>
        
        <br><br>
        <!-------------------Add new product-------------------------------->
        <h1 align="center">Add New Product</h1>
        <div align="center">
            <form method="post" action="manager_action.jsp">
                <label>Name: </label><input type="text" placeholder="Product Name" name="name" required class="form-control"/><br><br>
                <label>Category: </label>
                    <select name="category" required class="form-control">
                        <option value="Men's Clothing">Men's Clothing</option>
                        <option value="Women's Clothing">Women's Clothing</option>
                        <option value="kids Clothing">Kids Clothing</option>
                        <option value="Handbags">Handbags</option>
                        <option value="Shoes">Shoes</option>
                    </select><br><br>
                <label>Inventory: </label>
                <input type="number" size="100" name="inventory" required placeholder="Numeric Number" class="form-control"/><br><br>
                <label>Price: </label>
                <input type="number" step="any" size="30" name="price" required  placeholder="Price" class="form-control"/><br><br>
                <label>Cost: </label>
                <input type="number" size="30" step="any" name="cost" required placeholder="Cost" class="form-control"/><br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
        </div><br>
        <br>
        <%
            int productID;
            int inventory;
            double price;
            double cost;
            if(session.getAttribute("manager")!=null){
                if(session.getAttribute("managerID")!=null){
                    int managerID = Integer.parseInt(session.getAttribute("managerID").toString());
                    Manager manager = new Manager(managerID);
                    System.out.println(managerID);
                    if(request.getParameter("name")!=null && request.getParameter("category")!=null && request.getParameter("inventory")!=null
                            && request.getParameter("price")!=null && request.getParameter("cost")!=null){
                        String name = request.getParameter("name");
                        System.out.println("Name: "+name);
                        String category = request.getParameter("category");
                        System.out.println("Category: "+category);
                        if(!request.getParameter("inventory").equals("")){
                            inventory = Integer.parseInt(request.getParameter("inventory"));
                        }else{
                            inventory = 0;
                        }
                        System.out.println("Inventory: "+inventory);
                        
                        if(request.getParameter("price").equals("")){
                            price = 0;
                        }else{
                            price = Double.parseDouble(request.getParameter("price"));
                        }
                        System.out.println("Price: "+price);
                        if(request.getParameter("cost").equals("")){
                            cost = 0;
                        }else{
                            cost = Double.parseDouble(request.getParameter("cost"));
                        }
                        System.out.println("Cost: "+cost);
                        if(manager.findProductID(name, category, inventory, price, cost)!=0){
                            productID = manager.findProductID(name, category, inventory, price, cost);
                            out.println("<script language='javascript'>alert('Product already exists! Please update inventory!   Product ID:"+productID+" ')</script>"); 
                        }else{
                            Product product = manager.addProduct(name, category, inventory, price, cost);
                            productID = manager.findProductID(name, category, inventory, price, cost);
                            out.println("<script language='javascript'>alert('Product added successfully!   Product ID:"+productID+" ')</script>"); 
                            if(inventory<100){
                            out.println("<script language='javascript'>alert('Inventory less than 100!')</script>"); 
                            }
                            
                            out.println("<table  border='2' class='table table-striped, table table-hover' align='center'>");
                            out.println("<tr>");
                            out.println("<th>Product ID</th>");
                            out.println("<th>Product name</th>");
                            out.println("<th>Category</th>");
                            out.println("<th>Inventory</th>");
                            out.println("<th>Price</th>");
                            out.println("<th>Cost</th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td>"+productID+"</td>");
                            out.println("<td>"+product.getName()+"</td>");
                            out.println("<td>"+product.getCategory()+"</td>");
                            out.println("<td>"+product.getInventory()+"</td>");
                            out.println("<td>"+product.getPrice()+"</td>");
                            out.println("<td>"+product.getCost()+"</td>");
                            out.println("</tr>");
                            out.println("</table>");
                        }
                        
                        
                    }
                    
                }else{
                    response.sendRedirect("login_manager.jsp");
                }
            }
        
        
        
        
        
        %>
        
        
        <br><br>
        
        <!-------------------Aggregation View-------------------------------->
        <h1 align="center">Aggregation View For Manager</h1>
        <div align="center">
            <form method="post" action="manager_action.jsp">
                <label>Category of Customer: </label>
                <select name="customer" class="form-control" required>
                        <option value="Home"> Home Customer </option>
                        <option value="Business"> Business Customer </option>
                    </select>
                <br><br>
                <label>Time Period: </label>
                    <select name="timePeriod" required class="form-control">
                        <option value="1000"> All </option>
                        <option value="30"> Last 30 Days </option>
                        <option value="60"> Last 60 Days </option>
                        <option value="90"> Last 90 Days </option>
                    </select>
                    <br><br>
                    <label>Top Numbers: </label>
                    <select name="top" required class="form-control">
                        <option value="all"> All </option>
                        <option value="10"> Top 10 </option>
                    </select>
                    <br><br>
                    <label>Order By: </label>
                    <select name="orderBy" required class="form-control"> 
                        <option value="profit"> Profit </option>
                        <option value="total"> Total </option>
                        <option value="quantity"> Quantity </option>
                    </select>
                    <br><br>
                <label>Aggregation By: </label>
                <input name="groupBy" type="radio" value="order_detail.productID" required> Product 
                <input name="groupBy" type="radio" value="product.category"> Category 
                <input name="groupBy" type="radio" value="store.regionID"> Region 
                <input name="groupBy" type="radio" value="salesman.storeID"> Store 
                <input name="groupBy" type="radio" value="orders.salesID"> Salesman
                <input name="groupBy" type="radio" value="orders.customerID"> Customer
                <br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
        </div><br><br>
        <%
            DbUtilities db = new DbUtilities();
            String sql;
            int groupBy = 0;
            String aggregationCondition;
            if(session.getAttribute("manager")!=null){
                if(session.getAttribute("managerID")!=null){
                    if(request.getParameter("customer")!=null && request.getParameter("timePeriod")!=null && request.getParameter("top")!=null
                            && request.getParameter("orderBy")!=null && request.getParameter("groupBy")!=null){
                        String aggCondition = request.getParameter("groupBy");
                        String customerKind = request.getParameter("customer");
                        int period = Integer.parseInt(request.getParameter("timePeriod"));
                        String orderBy = request.getParameter("orderBy");
                        if(request.getParameter("top").equals("all")){
                            //all records
                            sql = "select "+aggCondition+", "+
                                "sum(quantity) as quantity, "+
                                "sum(order_detail.price*order_detail.quantity) as total, "+
                                "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                                "from department_store.order_detail, department_store.orders, department_store.salesman, "+
                                "department_store.customer, department_store.store, department_store.product "+
                                "where orders.orderID = order_detail.orderID "+
                                "and orders.salesID = salesman.salesID "+
                                "and orders.customerID = customer.customerID "+
                                "and salesman.storeID = store.storeID "+
                                "and order_detail.productID = product.productID "+
                                "and customer.kind = '"+customerKind+"' "+
                                "and orders.date BETWEEN SYSDATE() - INTERVAL "+period+" DAY AND SYSDATE() "+
                                "group by "+aggCondition+" "+
                                "order by "+orderBy+" DESC";
                         
                        }else{
                            //only top 10 records
                            sql = "select "+aggCondition+" ,"+
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
                                "and customer.kind = '"+customerKind+"' "+
                                "and orders.date BETWEEN SYSDATE() - INTERVAL "+period+" DAY AND SYSDATE() "+
                                "group by "+aggCondition+" "+
                                "order by "+orderBy+" DESC "+
                                "limit 0,10";
                        }
                        ResultSet rs = db.getResultSet(sql);
                        out.println("<table align='center' border='2' class='table table-striped, table table-hover'>");
                        out.println("<tr>");
                        out.println("<th>"+aggCondition+"</th>");
                        out.println("<th>Quantity</th>");
                        out.println("<th>Total</th>");
                        out.println("<th>Profit</th>");
                        out.println("</tr>");
                        while(rs.next()){
                            if(aggCondition.contains("ID")){
                                groupBy = rs.getInt(aggCondition);
                                aggregationCondition = String.valueOf(groupBy);
                            }else{
                                aggregationCondition = rs.getString(aggCondition);
                            }
                            int quantity = rs.getInt("quantity");
                            double total = rs.getDouble("total");
                            double profit = rs.getDouble("profit");
                            out.println("<tr>");
                            out.println("<td>"+aggregationCondition+"</td>");
                            out.println("<td>"+quantity+"</td>");
                            out.println("<td>"+total+"</td>");
                            out.println("<td>"+profit+"</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                    }
                }else{
                    response.sendRedirect("login_manager.jsp");
                }
            }
        
        %>
          
        
        
        
        <br><br>
        <!-------------------Find out which customer bought the most product-------------------------------->
        <h1 align="center">View Top Customer for Specific Product</h1>
        <div align="center">
            <form method="post" action="manager_action.jsp">
                <label>Category of Customer: </label>
                    <select name="customer" required class="form-control">
                        <option value="Home"> Home Customer </option>
                        <option value="Business"> Business Customer </option>
                    </select><br><br>
                <label>Time Period: </label>
                <select name="timePeriod" required class="form-control">
                        <option value="1000"> All </option>
                        <option value="30"> Last 30 Days </option>
                        <option value="60"> Last 60 Days </option>
                        <option value="90"> Last 90 Days </option>
                    </select>
                <br><br>
                <label>Order By: </label>
                    <select name="orderBy" required class="form-control">
                        <option value="profit"> Profit </option>
                        <option value="total"> Total </option>
                        <option value="quantity"> Quantity </option>
                    </select><br><br>
                <label>Product Name: <input  name="productName" type="text" placeholder="Product Name" size = "100" required class="form-control"/> (Precise Query)</label><br><br>
                <input type="submit" value="Submit Query"  class="btn btn-default"/>
            </form>
        </div>
        <br><br>
        
           <%
                
                
                
                
                //where customer.kind=customerCategory and product.name=productName
                //Order by orderCondition
                db = new DbUtilities();
                if(request.getParameter("productName")!=null && request.getParameter("customer")!=null 
                        && request.getParameter("timePeriod")!=null && request.getParameter("orderBy")!=null){
                    String name=request.getParameter("productName");
                    //System.out.println(name+"name");
                    String customerkind = request.getParameter("customer");
                    //System.out.println("customerkind:"+customerkind);
                    int time = Integer.parseInt(request.getParameter("timePeriod"));
                    //System.out.println("time:"+time);
                    String orderCondition = request.getParameter("orderBy");
                    //System.out.println("condition:"+orderCondition);
                    sql = "select orders.customerID, "+
                    "sum(quantity) as quantity, "+
                    "sum(order_detail.price*order_detail.quantity) as total, "+
                    "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                    "from department_store.order_detail, department_store.orders, "+
                    "department_store.customer, department_store.product "+
                    "where orders.orderID = order_detail.orderID "+
                    "and orders.customerID = customer.customerID "+
                    "and order_detail.productID = product.productID "+
                    "and product.name = '"+name+"' "+
                    "and customer.kind = '"+customerkind+"' "+
                    "and orders.date BETWEEN SYSDATE() - INTERVAL "+time+" DAY AND SYSDATE() "+
                    "group by orders.customerID "+
                    "order by "+orderCondition+" DESC";
                    
                    ResultSet rs = db.getResultSet(sql);
                    try{
                        out.println("<table border='2' align='center' class='table table-striped, table table-hover'>");
                        out.println("<tr>");
                        out.println("<th>Product Name</th>");
                        out.println("<th>Customer ID</th>");
                        out.println("<th>Quantity</th>");
                        out.println("<th>Total</th>");
                        out.println("<th>Profit</th>");
                        out.println("</tr>");
                        while(rs.next()){
                        int customerID = rs.getInt("orders.customerID");
                        //System.out.println(customerID);
                        int quantity = rs.getInt("quantity");
                        //System.out.println(quantity);
                        double total = rs.getDouble("total");
                        //System.out.println(total);
                        double profit = rs.getDouble("profit");
                        //System.out.println(profit);

                        out.println("<tr>");
                        out.println("<td>"+name+"</td>");
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
                }
                
                out.println("</table>");
              
           
           %>
        
        
        
        
        <div align="center">
            <a href="index.html">
                <button class="btn btn-large" type="button">Back to Main Page~</button>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="login_manager.jsp">
                <button class="btn btn-large" type="button">Login into another manager account~</button>
            </a>
        </div>
        <br><br><br><br><br><br>
    </body>
</html>
