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
 * Product class
 *
 * @author yanma
 *
 * two functions: 1. find by product name 2. find by product category
 */
public class Product {

    private int productID;
    private String name;
    private String category;
    private int inventory;
    private double price;
    private double cost;

    DbUtilities db = new DbUtilities();

    public Product(int productID) {
        try {
            db = new DbUtilities();
            //select product by productID
            String sql = "select * from department_store.product where productID = " + productID + " ";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.productID = rs.getInt("productID");
                this.name = rs.getString("name");
                this.category = rs.getString("category");
                this.inventory = rs.getInt("inventory");
                this.price = rs.getDouble("price");
                this.cost = rs.getDouble("cost");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }

    }
    
    
    public Product(String name, String category, int inventory, double price, double cost){
        db = new DbUtilities();
        //insert into product table a new product
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
        this.cost = cost;
        String sql = "INSERT INTO department_store.product (name, category, inventory, price, cost) "+
        "VALUES ('"+this.name+"', \""+this.category+"\", "+this.inventory+", "+this.price+", "+this.cost+")";
        db.executeQuery(sql);
    }

    
    
    
    public void updateInventory(int productID, int inventory){
        db = new DbUtilities();
        String sql = "UPDATE department_store.product SET inventory="+inventory+" WHERE productID="+productID+" ;";
        db.executeQuery(sql);
    }
    
    public ArrayList<Product> findProductByName(String name) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
        db = new DbUtilities();
        try {
            //select product by name
            String sql = "select * from department_store.product where name like '%" + name + "%'";
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.productID = rs.getInt("productID");
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
    
    
    
    
    
    public ArrayList<Product> findProductByCategory(String category) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
        String sql = "";
        db = new DbUtilities();
        try {
            //select product by category
            if(category.equals("all")){
                sql = "select * from department_store.product;";
            }else {
                sql = "select * from department_store.product where category = \""+category+"\"";
            }
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.productID = rs.getInt("productID");
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
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
    
    
    
    

}
