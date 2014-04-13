/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.store;

import edu.pitt.utilities.DbUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanma
 */
public class BusinessCustomer {

    private int customerID;
    private String companyName;
    private String category;
    private int income;

    DbUtilities db = new DbUtilities();
    public BusinessCustomer(int customerID) {
        try {
            //select by customerID
            String sql = "select * from department_store.business_customer where customerID = '"+customerID+"'";
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.category = rs.getString("category");
                this.companyName = rs.getString("companyName");
                this.income = rs.getInt("income");
                this.customerID = rs.getInt("customerID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusinessCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
         
    }

    public BusinessCustomer(int customerID, String companyName, String category, int income) {
        //insert new business customer

        this.customerID = customerID;
        this.companyName = companyName;
        this.category = category;
        this.income = income;

        String sql = "INSERT INTO department_store.business_customer (customerID, companyName, category, income) "
                + "VALUES ('"+this.customerID+"', '"+this.companyName+"', '"+this.category+"', '"+this.income+"' )"; 
        db.executeQuery(sql);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

}
