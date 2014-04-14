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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanma
 */
public class Manager {
    private int managerID;
    private String email;
    private String password;
    private String name;
    private int salary;
    private String address;
    
    DbUtilities db = new DbUtilities();
    
    public Manager(int managerID){
        try {
            //select manager
            String sql = "select * from department_store.manager where managerID = '"+managerID+"'";
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.managerID = rs.getInt("managerID");
                this.email = rs.getString("email");
                this.name = rs.getString("name");
                this.salary = rs.getInt("salary");
                this.address = rs.getString("address");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
    }
    
    //put this method into the view result page
    //这个方法也写入jsp页面   
    public void mgrViewByOrderAggre(String customerCategory, int period, int amount, String orderCondition, String aggreCondition){
        String sql = "";
        if(amount==10){
            try {
                //where customer.kind=customerCategory
                //group by aggreCondition
                //order by orderCondition
                //limit 0, 10
                sql = "select '"+aggreCondition+"',"+
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
                        "and customer.kind = '"+customerCategory+"' "+
                        "and orders.date BETWEEN SYSDATE() - INTERVAL '"+period+"' DAY AND SYSDATE() "+
                        "group by '"+aggreCondition+"' "+
                        "order by '"+orderCondition+"' DESC "+
                        "limit 0,10";
                
                ResultSet rs = db.getResultSet(sql);
                while(rs.next()){
                    if(aggreCondition.contains("ID")){
                        int aggregationID = rs.getInt("aggreCondition");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                        
                        
                    }else{
                        String aggregationCondition = rs.getString("aggreCondition");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                db.closeDbConnection();
            }
            
            
        }else{
            
            try {
                //where customer.kind=customerCategory
                //group by aggreCondition
                //order by orderCondition
                
                sql = "select '"+aggreCondition+"', "+
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
                        "and customer.kind = '"+customerCategory+"' "+
                        "and orders.date BETWEEN SYSDATE() - INTERVAL '"+period+"' DAY AND SYSDATE() "+
                        "group by '"+aggreCondition+"'"+
                        "order by '"+orderCondition+"' DESC";
                
                ResultSet rs = db.getResultSet(sql);
                while(rs.next()){
                    if(aggreCondition.contains("ID")){
                        int aggregationID = rs.getInt("aggreCondition");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                        
                        
                    }else{
                        String aggregationCondition = rs.getString("aggreCondition");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                    }
                }   
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                db.closeDbConnection();
            }
        }
    }
    //这个方法的内容在jsp里写
    //在while循环里   得到值 然后写入各个column
    public void mgrViewByOrderProduct(String customerCategory, int period, String productName, String orderCondition){
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        try {
            //where customer.kind=customerCategory and product.name=productName
            //Order by orderCondition
            String sql = "select orders.customerID, "+
                    "sum(quantity) as quantity, "+
                    "sum(order_detail.price*order_detail.quantity) as total, "+
                    "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                    "from department_store.order_detail, department_store.orders, "+
                    "department_store.customer, department_store.product "+
                    "where orders.orderID = order_detail.orderID "+
                    "and orders.customerID = customer.customerID "+
                    "and order_detail.productID = product.productID "+
                    "and product.name = '"+productName+"' "+
                    "and customer.kind = '"+customerCategory+"' "+
                    "and orders.date BETWEEN SYSDATE() - INTERVAL '"+period+"' DAY AND SYSDATE() "+
                    "group by orders.customerID "+
                    "order by '"+orderCondition+"' DESC";
            
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                int customerID = rs.getInt("orders.customerID");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                double profit = rs.getDouble("profit");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
    }
    
    public void updateInventory(int productID, int inventory){
        //update product inventory
        //find product by productID
        String sql = "UPDATE department_store.product SET inventory='"+inventory+"'"+
		"WHERE productID = '"+productID+"'";
        
        db.executeQuery(sql);
        
    }
    
    public void addProduct(String name, String category, int inventory, double price, double cost){
        Product product = new Product(name, category, inventory, price, cost);
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
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
