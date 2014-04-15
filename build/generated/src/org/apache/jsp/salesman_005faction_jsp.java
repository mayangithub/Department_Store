package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import edu.pitt.store.Product;
import java.sql.ResultSet;
import edu.pitt.utilities.DbUtilities;

public final class salesman_005faction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Salesman Operation Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Browse product</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <p>Category of Products: </p>\n");
      out.write("                <form method=\"get\" action=\"\">\n");
      out.write("                    <select name=\"category\">\n");
      out.write("                        <option value=\"Men's Clothing\">Men's Clothing</option>\n");
      out.write("                        <option value=\"Women's Clothing\">Women's Clothing</option>\n");
      out.write("                        <option value=\"kids Clothing\">Kids Clothing</option>\n");
      out.write("                        <option value=\"Handbags\">Handbags</option>\n");
      out.write("                        <option value=\"Shoes\">Shoes</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("                </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        ");

             String sql = "select * from department_store.product where category = 'Handbags'";
            DbUtilities db = new DbUtilities();
            ResultSet rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
        
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">Search Product</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("            <p>Product name:\n");
      out.write("                <input type=\"text\" name=\"productName\" placeholder=\"Product Name\"/>（vague search）</p>\n");
      out.write("            <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        ");

            sql = "select * from department_store.product where name like '%b%'";;
            rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
            while(rs.next()){
                int productID = rs.getInt("productID");
                Product product = new Product(productID);
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
            
        
        
        
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">Search Product</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("                <p>Product ID: \n");
      out.write("                <input type=\"text\" value=\"\" name=\"productID\" placeholder=\"Product ID\" /></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\"  />\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        <br>\n");
      out.write("        ");

            if(request.getParameter("productID")!=null){
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = new Product(productID);
                out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Product ID</th>");   
                out.println("<th>Product name</th>");
                out.println("<th>Category</th>");
                out.println("<th>Inventory</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td>"+product.getProductID()+"</td>");
                out.println("<td>"+product.getName()+"</td>");
                out.println("<td>"+product.getCategory()+"</td>");
                out.println("<td>"+product.getInventory()+"</td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getCost()+"</td>");
                out.println("</tr>");
                
            
            out.println("</table>");
            
            }
            
        
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">Search for Orders</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"\" >\n");
      out.write("                <p>Time period: \n");
      out.write("                <select name=\"timePeriod\">\n");
      out.write("                    <option value=\"30\">30 Days</option>\n");
      out.write("                    <option value=\"60\">60 Days</option>\n");
      out.write("                    <option value=\"90\">90 Days</option>\n");
      out.write("                    <option value=\"1000\"> All </option>\n");
      out.write("                </select></p>\n");
      out.write("                <p>Product ID: \n");
      out.write("                    <input value=\"\" name=\"productID\" type=\"text\" placeholder=\"Product ID\"/></p>\n");
      out.write("                <p>Order ID: \n");
      out.write("                    <input type=\"text\" name=\"orderID\" value=\"\" placeholder=\"Order ID\" /></p>\n");
      out.write("                <p>Customer ID: \n");
      out.write("                    <input type=\"text\" name=\"customerID\" value=\"\" placeholder=\"Customer ID\" /></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br><br><br>\n");
      out.write("        ");

            int salesID = 25;
            int period = 1000;
            sql = "select orders.orderID as order_ID, orders.date as order_date, order_detail.productID as product_ID,"
                    + " order_detail.price as price, order_detail.cost as cost, order_detail.quantity as quantity, "
                    + "orders.salesID as salesman_ID, orders.customerID as customer_ID "
                    + "from department_store.orders, department_store.order_detail "
                    + "where orders.salesID = " + salesID + " "
                    + "and date BETWEEN SYSDATE() - INTERVAL " + period + " DAY AND SYSDATE() "
                    + "and orders.orderID = order_detail.orderID "
                    + "order by date DESC";
            rs = db.getResultSet(sql);
            out.println("<table align='center' border='2'>");
                out.println("<tr>");
                out.println("<th>Order ID</th>");  
                out.println("<th>Salesman ID</th>");
                out.println("<th>Customer ID</th>");
                out.println("<th>Order Date</th>");
                out.println("<th>Product ID</th>");
                out.println("<th>Quantity</th>");
                out.println("<th>Price</th>");
                out.println("<th>Cost</th>");
                
                out.println("</tr>");
            while(rs.next()){
                int orderID = rs.getInt("order_ID");
                int customerID = rs.getInt("customer_ID");
                Date date = rs.getDate("order_date");
                int productID = rs.getInt("product_ID");
                double price = rs.getDouble("price");
                double cost = rs.getDouble("cost");
                int quantity = rs.getInt("quantity");
                out.println("<tr>");
                out.println("<td>"+orderID+"</td>");
                out.println("<td>"+salesID+"</td>");
                out.println("<th>"+customerID+"</th>");
                out.println("<td>"+date+"</td>");
                out.println("<td>"+productID+"</td>");
                out.println("<td>"+quantity+"</td>");
                out.println("<td>"+price+"</td>");
                out.println("<td>"+cost+"</td>");
                
                out.println("</tr>");
                
                
            }
            out.println("</table>");
            
            
        
      out.write("\n");
      out.write("        <br><br><br><br><br><br><br>\n");
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
