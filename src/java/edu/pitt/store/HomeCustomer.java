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
public class HomeCustomer {

    private int customerID;
    private int age;
    private String gender;
    private String marriage;
    private int income;
    
    DbUtilities db = new DbUtilities();
    
    public HomeCustomer(int customerID){
        try {
            //select customer by customerID
            String sql = "select * from department_store.home_customer where customerID = "+customerID+"";
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.customerID = rs.getInt("customerID");
                this.age = rs.getInt("age");
                this.gender = rs.getString("gender");
                this.marriage = rs.getString("marriage");
                this.income = rs.getInt("income");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
        
    }
    
    public HomeCustomer(int customerID, int age, String gender, String marriage, int income){
        //insert new home customer 
        this.customerID = customerID;
        this.age = age;
        this.gender = gender;
        this.marriage = marriage;
        this.income = income;
        
        String sql = "INSERT INTO department_store.home_customer (customerID, age, gender, marriage, income) VALUES ("
                +this.customerID+", "+this.age+", '"+this.gender+"', '"+this.marriage+"', "+this.income+")";
        db.executeQuery(sql);
                
    }
    
    
    public ArrayList<Product> findProductByCategory(String category) {
        ArrayList<Product> matchedProductList = new ArrayList<Product>();
        String sql = "";
        try {
            //select product by category
            if(category.equals("all")){
                sql = "select * from department_store.product";
            }else if(category.contains("Men")){
                sql = "SELECT * FROM department_store.product where category=\"Men's Clothing\"";
            }else if(category.contains("Women")){
                sql = "SELECT * FROM department_store.product where category=\"Women's Clothing\"";
            }else if(category.contains("kids")){
                sql="SELECT * FROM department_store.product where category='kids Clothing';";
            }else if(category.contains("Handbags")){
                sql="SELECT * FROM department_store.product where category='Handbags'";
            }else {
                sql="SELECT * FROM department_store.product where category='Shoes'";
            }
                            
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                int productID = rs.getInt("productID");
                System.out.println("------"+productID+"--------");
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


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    
    
    
    
}
