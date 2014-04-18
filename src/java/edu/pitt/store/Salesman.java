/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.store;

import edu.pitt.utilities.DbUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanma
 */
public class Salesman {

    private int salesID;
    private String email;
    private String password;
    private String name;
    private int storeID;
    private int salary;
    private String address;

    DbUtilities db = new DbUtilities();

    public Salesman(int salesID) {
        try {
            db = new DbUtilities();
            //select by salesID
            String sql = "select * from department_store.salesman where salesID = " + salesID + " ";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.salesID = rs.getInt("salesID");
                this.address = rs.getString("address");
                this.email = rs.getString("email");
                this.name = rs.getString("name");
                this.storeID = rs.getInt("storeID");
                this.salary = rs.getInt("salary");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }

    }

    public ArrayList<Order> salesFindOrderByDatePeriod(int salesID, int period) {
            ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        try {
            db = new DbUtilities();
            //select by salesID and period time
            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, "
                    + "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID from department_store.orders, "
                    + "department_store.order_detail where orders.salesID = "+ salesID +" and date BETWEEN SYSDATE() - INTERVAL "
                    + period +" DAY AND SYSDATE() and orders.orderID = order_detail.orderID order by date DESC";
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                int orderID = rs.getInt("order_ID");
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;
    }

    public ArrayList<Order> salesFindOrderByProductID(int salesID, int productID, int period) {
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        try {
            db = new DbUtilities();
            //select by salesID, period time and productID
            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID "
                    + "as product_ID, order_detail.price as price, order_detail.cost as cost, "
                    + "order_detail.quantity as quantity, orders.salesID as salesman_ID, orders.customerID as "
                    + "customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.salesID = " + salesID + " "
                    + "and order_detail.productID= " + productID + " "
                    + "and date BETWEEN SYSDATE() - INTERVAL " + period + " DAY AND SYSDATE() "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                int orderID = rs.getInt("order_ID");
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;

    }

    public ArrayList<Order> salesFindOrderByOrderID(int salesID, int orderID) {
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        db = new DbUtilities();
        try {
            //select by salesID, period time, and orderID
            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, "
                    + " order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.orderID= " + orderID + " "
                    + "and orders.salesID = " + salesID + " "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                orderID = rs.getInt("order_ID");
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;

    }

    public ArrayList<Order> salesFindOrderByCustomerID(int salesID, int customerID, int period) {
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        db = new DbUtilities();
        try {
            //select by salesID, customerID, and period time

            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, "
                    + "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.salesID = " + salesID + " "
                    + "and orders.customerID= " + customerID + " "
                    + "and date BETWEEN SYSDATE() - INTERVAL " + period + " DAY AND SYSDATE() "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                int orderID = rs.getInt("order_ID");
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;

    }
    
    
    
    
    public ArrayList<Order> salesFindOrderByCustomerProductID(int salesID, int customerID, int productID, int period) {
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        db = new DbUtilities();
        try {
            //select by salesID, customerID, and period time and productID

            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, "
                    + "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.salesID = " + salesID + " "
                    + "and orders.customerID= " + customerID + " "
                    + "and order_detail.productID= " + productID + " "
                    + "and date BETWEEN SYSDATE() - INTERVAL " + period + " DAY AND SYSDATE() "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                int orderID = rs.getInt("order_ID");
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;

    }
    
    
    
    
    
    
    
    //browse products by category
    public ArrayList<Product> findProductByCategory(String category) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
        String sql = "";
        db = new DbUtilities();
        try {
            //select product by category
            if(category.equals("all")){
                sql = "select * from department_store.product ";
            }else {
                sql = "select * from department_store.product where category = \""+category+"\"";
            }
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                matchedProductList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedProductList;

    }

    public ArrayList<Product> findProductByName(String name) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
        db = new DbUtilities();
        try {
            //select product by name
            String sql = "select * from department_store.product where name like '%" + name + "%'";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                matchedProductList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
            return matchedProductList;
    }
    
    //find product by id
    public Product findProductByProductID(int productID){
        db = new DbUtilities();
        Product product = null;
        try {
            String sql = "SELECT productID FROM department_store.product where productID = "+productID;
            ResultSet rs = db.getResultSet(sql);
            if(rs.next()){
                productID = rs.getInt("productID");
                System.out.println(productID);
                product = new Product(productID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
    
    
    public void placeOrder(int salesID, int productID, int customerID, int quantity){
        
        Product product = findProductByProductID(productID);
        System.out.println("inventory before:"+product.getInventory());
        product.updateInventory(productID, product.getInventory()-quantity);
        System.out.println("inventory after:"+product.getInventory());
        double price = product.getPrice();
        double cost = product.getCost();
        Order order = new Order(customerID, salesID);
        int orderID = order.getOrderID();
        System.out.println("orderID: "+orderID+"when insert new order");
        Order o_detail = new Order(orderID, productID, quantity, price, cost);
        System.out.println("quantity:"+o_detail.getQuantity());
    }
    
    
    

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
