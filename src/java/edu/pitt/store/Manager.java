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
    
    
    public ArrayList<Order> mgrViewByOrderAggre(String customerCategory, int period, int amount, String orderCondition, String aggreCondition){
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        String sql = "";
        if(amount==10){
            sql = "";
            //where customer.kind=customerCategory 
            //group by aggreCondition
            //order by orderCondition
            //limit 0, 10
            
        }else{
            sql = "";
            //where customer.kind=customerCategory 
            //group by aggreCondition
            //order by orderCondition
        }
        return matchedOrderList;
    }
    
    public ArrayList<Order> mgrViewByOrderProduct(String customerCategory, int period, String productName, String orderCondition){
        ArrayList<Order> matchedOrderList = new ArrayList<Order>();
        String sql = "";
        //where customer.kind=customerCategory and product.name=productName
        //Order by orderCondition
        return matchedOrderList;
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
