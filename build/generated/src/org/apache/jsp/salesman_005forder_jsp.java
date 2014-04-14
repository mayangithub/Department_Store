package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.Order;
import edu.pitt.store.Product;

public final class salesman_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Salesman Order Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Salesman, You can make an order</h1>\n");
      out.write("        <div align=\"center\" > \n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                <table border=\"2\" >\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Purchase Option</th>\n");
      out.write("                        <th>Enter</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Product ID</td>\n");
      out.write("                        <td><input type=\"text\" value=\"\" name=\"productID\" placeholder=\"Product ID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Quantity</td>\n");
      out.write("                        <td><input type=\"number\" min=\"1\" name=\"quantity\" placeholder=\"Numeric Amount\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Customer ID</td>\n");
      out.write("                        <td><input type=\"text\" value=\"\" name=\"customerID\" placeholder=\"Customer ID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Salesman ID</td>\n");
      out.write("                        <td><input type=\"text\" value=\"\" name=\"salesmanID\" placeholder=\"Salesman ID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" value=\"Submit Order\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");

            /*

                if (request.getParameter("quantity") != null && request.getParameter("customerID") != null) {
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    if (request.getParameter("productID") != null) {
                        int productID = Integer.parseInt(request.getParameter("productID"));
                        Product product = new Product(productID);
                        if (quantity < product.getInventory()) {
                            out.println("<script language='javascript'>alert('Inventory is less than your quantity. Please order less.')</script>");
                        } else {
                            int salesID = 20;
                            int customerID = Integer.parseInt(request.getParameter("customerID"));
                            Order order = new Order(customerID, salesID);
                            double price = product.getPrice();
                            double cost = product.getCost();
                            Order newOrder = new Order(order.getOrderID(), productID, quantity, price, cost);

                            out.println("<table align='center' border='2'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Product ID</th>");
                            out.println("<th>Quantity</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Price</th>");
                            out.println("<th>Cost</th>");
                            out.println("</tr>");

                            out.println("<tr>");
                            out.println("<td>" + order.getOrderID() + "</td>");
                            out.println("<td>" + product.getProductID() + "</td>");
                            out.println("<td>" + order.getQuantity() + "</td>");
                            out.println("<td>" + order.getCustomerID() + "</td>");
                            out.println("<td>" + order.getSalesID() + "</td>");
                            out.println("<td>" + newOrder.getPrice() + "</td>");
                            out.println("<td>" + newOrder.getCost() + "</td>");
                            out.println("</tr>");

                        }
                    }

                }

            }
                    
                    */

            
            
            
            
            
            
                    int quantity = 50;
                    int customerID = 163;
                    int productID = 75;
                        Product product = new Product(productID);
                        int inventory = product.getInventory();
                        out.println(inventory);
                        
                            out.println("<script language='javascript'>alert('Inventory is less than your quantity. Please order less.')</script>");
                         /*else {
                            int salesID = 20;
                            Order order = new Order(customerID, salesID);
                            double price = product.getPrice();
                            double cost = product.getCost();
                            Order newOrder = new Order(order.getOrderID(), productID, quantity, price, cost);

                            out.println("<table align='center' border='2'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Product ID</th>");
                            out.println("<th>Quantity</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Price</th>");
                            out.println("<th>Cost</th>");
                            out.println("</tr>");

                            out.println("<tr>");
                            out.println("<td>" + order.getOrderID() + "</td>");
                            out.println("<td>" + product.getProductID() + "</td>");
                            out.println("<td>" + order.getQuantity() + "</td>");
                            out.println("<td>" + order.getCustomerID() + "</td>");
                            out.println("<td>" + order.getSalesID() + "</td>");
                            out.println("<td>" + newOrder.getPrice() + "</td>");
                            out.println("<td>" + newOrder.getCost() + "</td>");
                            out.println("</tr>");

                        }
                                
                    }
*/
                

            

        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <h1 align=\"center\">Order Confirm</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table border=\"2\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Purchase Option</th>\n");
      out.write("                <th>Enter</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Product ID</td>\n");
      out.write("                <td>48</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Quantity</td>\n");
      out.write("                <td>3</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Customer ID</td>\n");
      out.write("                <td>2000</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Salesman ID</td>\n");
      out.write("                <td>10</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");
            out.println (
        "<script language='javascript'>alert('The inventory of this product is less than 100.')</script>");
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
