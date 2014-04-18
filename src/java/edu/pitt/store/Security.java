package edu.pitt.store;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.pitt.utilities.DbUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Security class
 *
 * @author yanma
 * @since 2014.01.23
 * @version week3
 */
public class Security {

    private int customerID;
    private int salesID;
    private int managerID;
    private String loginEmail;
    private String password;
    private String kind;

    public HomeCustomer validateHomeCustomerLogin(String loginEmail, String password) {
        this.loginEmail = loginEmail;
        this.password = password;
        String sql = "SELECT * FROM department_store.customer WHERE email = '" + this.loginEmail + "' and password = '" + this.password + "';";
        DbUtilities db = new DbUtilities();
        try {
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.customerID = rs.getInt("customerID");
                this.kind = rs.getString("kind");
                if (this.kind.equals("Home")) {
                    HomeCustomer authenticatedHomeCustomer = new HomeCustomer(this.customerID);
                    return authenticatedHomeCustomer;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.closeDbConnection();
        }

        System.out.println("No such customer exist!");
        return null;
    }
    
    
    public BusinessCustomer validateBusinessCustomerLogin(String loginEmail, String password) {
        this.loginEmail = loginEmail;
        this.password = password;
        String sql = "SELECT * FROM department_store.customer WHERE email = '" + this.loginEmail + "' and password = '" + this.password + "';";
        DbUtilities db = new DbUtilities();
        try {
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.customerID = rs.getInt("customerID");
                this.kind = rs.getString("kind");
                if (this.kind.equals("Business")) {
                    BusinessCustomer authenticatedBusinessCustomer = new BusinessCustomer(this.customerID);
                    return authenticatedBusinessCustomer;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.closeDbConnection();
        }

        System.out.println("No such customer exist!");
        return null;
    }
    
    
    public Salesman validateSalesmanLogin(String loginEmail, String password) {
        this.loginEmail = loginEmail;
        this.password = password;
        String sql = "SELECT * FROM department_store.salesman WHERE email = '" + this.loginEmail + "' and password = '" + this.password + "';";
        DbUtilities db = new DbUtilities();
        try {
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.salesID = rs.getInt("salesID");
                Salesman validSalesman = new Salesman(this.salesID);
                return validSalesman;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.closeDbConnection();
        }

        System.out.println("No such salesman exist!");
        return null;
    }
    
    
    
    public Manager validateManagerLogin(String loginEmail, String password) {
        this.loginEmail = loginEmail;
        this.password = password;
        String sql = "SELECT * FROM department_store.manager WHERE email = '" + this.loginEmail + "' and password = '" + this.password + "';";
        DbUtilities db = new DbUtilities();
        try {
            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                this.managerID = rs.getInt("managerID");
                Manager validManager = new Manager(this.managerID);
                return validManager;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.closeDbConnection();
        }

        System.out.println("No such manager exist!");
        return null;
    }
    
    
    public boolean findExistingCustomer(String email) {
        DbUtilities db = new DbUtilities();
        try {
            //select customer by email
            String sql = "select * from department_store.customer where email = '" + email + "';";
            ResultSet rs = db.getResultSet(sql);
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        return false;

    }
    
    
    
    
    
    public int findCustomerByEmail(String email){
         DbUtilities db = new DbUtilities();
        try {
            
            String sql = "SELECT customerID FROM department_store.customer WHERE email = '"+email+"'";
            ResultSet rs = db.getResultSet(sql);
            if(rs.next()){
                int customerid = rs.getInt("customerID");
                
                return customerid;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
        return 0;
    }
    
    public int findSalesmanByEmail(String email){
         DbUtilities db = new DbUtilities();
        try {
            
            String sql = "SELECT salesID FROM department_store.salesman WHERE email = '"+email+"'";
            ResultSet rs = db.getResultSet(sql);
            if(rs.next()){
                int customerid = rs.getInt("salesID");
                
                return customerid;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
        return 0;
    }
     
     
     
     
    public int findManagerByEmail(String email){
         DbUtilities db = new DbUtilities();
        try {
            
            String sql = "SELECT managerID FROM department_store.manager WHERE email = '"+email+"'";
            ResultSet rs = db.getResultSet(sql);
            if(rs.next()){
                int customerid = rs.getInt("managerID");
                
                return customerid;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
        return 0;
    }
     
}
