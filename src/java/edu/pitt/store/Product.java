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
            //select product by productID
            String sql = "select * from department_store.product where productID = '" + productID + "'";
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

    public ArrayList<Product> findProductByName(String name) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
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
        try {
            //select product by category
            String sql = "select * from department_store.product where category = '"+category+"'";
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
