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
public class Order {
    private int orderID;
    private int customerID;
    private int salesID;
    private Date date;
    private int productID;
    private int quantity;
    private double price;
    private double cost;
    
    DbUtilities db = new DbUtilities();
    
    public Order(int orderID){
        try {
            //select order by orderID
            //select from both orders and order_details database
            String sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID,"+
            " order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "+
            "orders.salesID as salesman_ID, orders.customerID as customer_ID"+
            "from department_store.orders, department_store.order_detail"+
            "where orders.orderID = '"+orderID+"'"+
            "and orders.orderID = order_detail.orderID"+
            "order by date DESC";          
            
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.orderID = rs.getInt("order_ID");
                this.date = rs.getDate("order_date");
                this.productID = rs.getInt("product_ID");
                this.price = rs.getDouble("price");
                this.quantity = rs.getInt("quantity");
                this.salesID = rs.getInt("salesman_ID");
                this.customerID = rs.getInt("customer_ID");
                this.cost = rs.getDouble("cost");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
        
    }
    
    public Order(int customerID, int salesID){
    	//insert new order into order table
    	//insert sql statement
        this.customerID = customerID;
        this.salesID = salesID;
    	String sql = "INSERT INTO department_store.orders (customerID, salesID) VALUES ("+this.customerID+","+this.salesID+")";
        db.executeQuery(sql);
        
    }
    
    public Order(int orderID, int productID, int quantity, double price, double cost){
        //insert new order and order detail
        //1. insert new order      这里写一个sql语句
        
        //2. get orderID 
        //3. get productID
        //4. get product price & cost 
        //5. insert into order detail   这里有一个SQL语句
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
        String sql = "INSERT INTO department_store.order_detail (orderID, productID, quantity, price, cost) VALUES ('"+
                this.orderID+"', '"+this.productID+"', '"+this.quantity+"', '"+this.price+"', '"+this.cost+"' )";        
        db.executeQuery(sql);
        
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public DbUtilities getDb() {
        return db;
    }

    public void setDb(DbUtilities db) {
        this.db = db;
    }
    
    
    
}
