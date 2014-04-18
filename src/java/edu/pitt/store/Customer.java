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
public class Customer {

    private int customerID;
    private String email;
    private String password;
    private String kind;
    private String name;
    private String address;

    DbUtilities db = new DbUtilities();

    public Customer(int customerID) {
        db = new DbUtilities();
        try {
            //select customer by customerID
            String sql = "select * from department_store.customer where customerID = '" + customerID + "'";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.address = rs.getString("address");
                this.email = rs.getString("email");
                this.kind = rs.getString("kind");
                this.name = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
    }

    public Customer(String email, String password, String kind, String name, String address) {
        //insert a new customer
        this.email = email;
        this.password = password;
        this.kind = kind;
        this.name = name;
        this.address = address;
        db = new DbUtilities();
        String sql = "INSERT INTO customer (email, password, kind, name, address) VALUES ('"
                + this.email + "', '" + this.password + "', '" + this.kind + "', '" + this.name + "', '" + this.address + "')";
        db.executeQuery(sql);
    }
    
    
    public ArrayList<Order> customerFindOrder(int customerID, int period, int productID, int orderID) {
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        try {
            db = new DbUtilities();
            String sql="";
            if(orderID!=0){
                sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, " +
                    "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, " +
                    "orders.salesID as salesman_ID, orders.customerID as customer_ID " +
                    "from department_store.orders, department_store.order_detail " +
                    "where orders.customerID = "+customerID+" and orders.orderID = "+orderID+" and orders.orderID = order_detail.orderID " +
                    "order by date DESC;";
            }else{
                if(productID==0){
                    sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, " +
                          "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, " +
                          "orders.salesID as salesman_ID, orders.customerID as customer_ID " +
                          "from department_store.orders, department_store.order_detail " +
                          "where orders.customerID = "+customerID+" and date BETWEEN SYSDATE() - INTERVAL "+period+" DAY AND SYSDATE() " +
                          "and orders.orderID = order_detail.orderID " +
                          "order by date DESC;";
                }else{
                    sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID, " +
                    "order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, " +
                    "orders.salesID as salesman_ID, orders.customerID as customer_ID " +
                    "from department_store.orders, department_store.order_detail " +
                    "where orders.customerID = "+customerID + " and order_detail.productID= "+productID + " and date BETWEEN SYSDATE() - INTERVAL "+period+" DAY AND SYSDATE() " +
                    "and orders.orderID = order_detail.orderID order by date DESC";
                }
                
               
            }
            System.out.println(sql);
                
            
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                orderID = rs.getInt("order_ID");
                System.out.println(orderID);
                Order order = new Order(orderID);
                matchedOrderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return matchedOrderList;
    }
            
    
    
    public ArrayList<Product> customerFindProductByCategory(String category){
        ArrayList<Product> productList = new ArrayList<Product>();
        db = new DbUtilities();
        String sql;
        try {
            if(category.equals("all")){
                sql = "select * from department_store.product ";
            }else{
                sql = "select * from department_store.product where category = \""+category+"\"";
            }
            
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return productList;
    }
    

    public int getCustomerID() {
        
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
