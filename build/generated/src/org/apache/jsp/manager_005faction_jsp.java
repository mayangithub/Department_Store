package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.Manager;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import edu.pitt.utilities.DbUtilities;
import java.sql.ResultSet;
import edu.pitt.store.Product;
import java.util.ArrayList;

public final class manager_005faction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manager Operation Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Update Product Inventory</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                <p>Product ID: <input type=\"text\" value=\"\" name=\"productID\" placeholder=\"Product ID\" /></p>\n");
      out.write("                <p>Inventory Amount: <input type=\"text\" value=\"\" name=\"inventory\" placeholder=\"Numeric Amount\"/></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\"  />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        <h1 align=\"center\">Add New Product</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                <p>Name: <input type=\"text\" value=\"\" placeholder=\"Product Name\" name=\"name\" /></p>\n");
      out.write("                <p>Category: \n");
      out.write("                <select name=\"category\">\n");
      out.write("                        <option value=\"Men's Clothing\">Men's Clothing</option>\n");
      out.write("                        <option value=\"Women's Clothing\">Women's Clothing</option>\n");
      out.write("                        <option value=\"kids Clothing\">Kids Clothing</option>\n");
      out.write("                        <option value=\"Handbags\">Handbags</option>\n");
      out.write("                        <option value=\"Shoes\">Shoes</option>\n");
      out.write("                </select></p>\n");
      out.write("                <p>Inventory: <input type=\"text\" value=\"\" name=\"inventory\" placeholder=\"Numeric Number\" /></p>\n");
      out.write("                <p>Price: <input type=\"text\" name=\"price\" value=\"\" placeholder=\"Price\" /></p>\n");
      out.write("                <p>Cost: <input type=\"text\" name=\"cost\" value=\"\" placeholder=\"Cost\" /></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\"  />\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        <table  border='2' class=\"table table-striped, table table-hover\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product name</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("                    <th>Inventory</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                            <th>Cost</th>\n");
      out.write("                </tr>\n");
      out.write("        ");

        
                
                  
                        out.println("<tr>");
                        out.println("<td>101</td>");
                        out.println("<td>Queen Dress</td>");
                        out.println("<td>kids Clothing</td>");
                        out.println("<td>110</td>");
                        out.println("<td>30</td>");
                        out.println("<td>25</td>");
                        out.println("</tr>");
                    
               
                
            
            
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <br><br>\n");
      out.write("        <h1 align=\"center\">Aggregation View For Manager</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("                <p>Category of Customer: \n");
      out.write("                    <select name=\"customer\">\n");
      out.write("                        <option value=\"home_customer\">Home Customer</option>\n");
      out.write("                        <option value=\"business_customer\">Business Customer</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Time Period: \n");
      out.write("                    <select name=\"timePeriod\">\n");
      out.write("                        <option value=\"30\">30 Days</option>\n");
      out.write("                        <option value=\"60\">60 Days</option>\n");
      out.write("                        <option value=\"90\">90 Days</option>\n");
      out.write("                        <option value=\"1000\"> All </option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Top Numbers:\n");
      out.write("                    <select name=\"top\">\n");
      out.write("                        <option value=\"10\">10</option>\n");
      out.write("                        <option value=\"all\">All</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Order By: \n");
      out.write("                    <select name=\"orderBy\">\n");
      out.write("                        <option value=\"profit\">Profit</option>\n");
      out.write("                        <option value=\"total\">Total</option>\n");
      out.write("                        <option value=\"quantity\">Quantity</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Aggregation By: </p>\n");
      out.write("                <input type=\"radio\" value=\"order_detail.productID\"> Product \n");
      out.write("                <input type=\"radio\" value=\"product.category\"> Category \n");
      out.write("                <input type=\"radio\" value=\"stores.regionID\"> Region \n");
      out.write("                <input type=\"radio\" value=\"salesman.storeID\"> Store \n");
      out.write("                <input type=\"radio\" value=\"orders.salesID\"> Salesman\n");
      out.write("                <input type=\"radio\" value=\"orders.customerID\"> Customer\n");
      out.write("                <br><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        <table align=\"center\" border='2' class=\"table table-striped, table table-hover\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Salesman ID</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Total</th>\n");
      out.write("                <th>Profit</th>\n");
      out.write("            </tr> \n");
      out.write("            ");

                        DbUtilities db = new DbUtilities();
                        
              String sql = "select orders.salesID,"+
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
                        "and customer.kind = 'Home' "+
                        "and orders.date BETWEEN SYSDATE() - INTERVAL 60 DAY AND SYSDATE() "+
                        "group by salesID "+
                        "order by profit DESC "+
                        "limit 0,10";
                try{
                ResultSet rs = db.getResultSet(sql);
                while(rs.next()){
                    
                        int salesID = rs.getInt("orders.salesID");
                        int quantity = rs.getInt("quantity");
                        double total = rs.getDouble("total");
                        double profit = rs.getDouble("profit");
                        
                        out.println("<tr>");
                        out.println("<td>"+salesID+"</td>");
                        out.println("<td>"+quantity+"</td>");
                        out.println("<td>"+total+"</td>");
                        out.println("<td>"+profit+"</td>");
                        out.println("</tr>");
                }
                }catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">View Top Customer for Specific Product</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("                <p>Category of Customer: \n");
      out.write("                    <select name=\"customer\">\n");
      out.write("                        <option value=\"home_customer\">Home Customer</option>\n");
      out.write("                        <option value=\"business_customer\">Business Customer</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Time Period: \n");
      out.write("                    <select name=\"timePeriod\">\n");
      out.write("                        <option value=\"30\">30 Days</option>\n");
      out.write("                        <option value=\"60\">60 Days</option>\n");
      out.write("                        <option value=\"90\">90 Days</option>\n");
      out.write("                        <option value=\"1000\"> All </option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Order By: \n");
      out.write("                    <select name=\"orderBy\">\n");
      out.write("                        <option value=\"profit\">Profit</option>\n");
      out.write("                        <option value=\"total\">Total</option>\n");
      out.write("                        <option value=\"quantity\">Quantity</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("                <p>Product Name: <input value=\"\" name=\"productName\" type=\"text\" placeholder=\"Product Name\" /> (Precise Query)</p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <table border='2' align=\"center\" class=\"table table-striped, table table-hover\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Customer ID</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Total</th>\n");
      out.write("                <th>Profit</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("           ");

               
            //where customer.kind=customerCategory and product.name=productName
            //Order by orderCondition
            sql = "select orders.customerID, "+
                    "sum(quantity) as quantity, "+
                    "sum(order_detail.price*order_detail.quantity) as total, "+
                    "sum((order_detail.price-order_detail.cost)*order_detail.quantity) as profit "+
                    "from department_store.order_detail, department_store.orders, "+
                    "department_store.customer, department_store.product "+
                    "where orders.orderID = order_detail.orderID "+
                    "and orders.customerID = customer.customerID "+
                    "and order_detail.productID = product.productID "+
                    "and product.name = 'nycc' "+
                    "and customer.kind = 'Home' "+
                    "and orders.date BETWEEN SYSDATE() - INTERVAL 90 DAY AND SYSDATE() "+
                    "group by orders.customerID "+
                    "order by total DESC";
            
            ResultSet rs = db.getResultSet(sql);
            try{
            while(rs.next()){
                int customerID = rs.getInt("orders.customerID");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                double profit = rs.getDouble("profit");
                
                out.println("<tr>");
                out.println("<td>"+customerID+"</td>");
                out.println("<td>"+quantity+"</td>");
                out.println("<td>"+total+"</td>");
                out.println("<td>"+profit+"</td>");
                out.println("</tr>");
            }
            } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeDbConnection();
        }
        
           
           
           
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br><br><br><br>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
