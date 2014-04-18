package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.Customer;
import edu.pitt.store.Order;
import java.util.ArrayList;

public final class business_005fcustomer_005fsearchorder_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if(session.getAttribute("businessCustomer")==null){
        response.sendRedirect("login_business_customer.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Business Customer Search Orders</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Welcome! For Business Customer:</h1>\n");
      out.write("        <!---------------Search Orders by Time Period, Product ID, or Order ID ---------------------->\n");
      out.write("        <h3 align=\"center\">Search for Orders</h3>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"get\" action=\"business_customer_searchorder.jsp\" >\n");
      out.write("                <label>Time period: </label>\n");
      out.write("                <select name=\"timePeriod\" class=\"form-control\">\n");
      out.write("                    <option value=\"1000\" selected=\"selected\"> All Orders </option>\n");
      out.write("                    <option value=\"30\"> Last 30 Days </option>\n");
      out.write("                    <option value=\"60\"> Last 60 Days </option>\n");
      out.write("                    <option value=\"90\"> Last 90 Days </option>\n");
      out.write("                </select><br><br>\n");
      out.write("                <label>Product ID: \n");
      out.write("                    <input name=\"productID\" type=\"number\" placeholder=\"Product ID\" value=\"0\" required/></label><br><br>\n");
      out.write("                <label>Order ID: \n");
      out.write("                    <input type=\"text\" name=\"orderID\" placeholder=\"Order ID\"  value=\"0\" required/></label><br><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\" class=\"btn btn-default\" />\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        ");

                int period = 1000;
                int productID = 0;
                int orderID = 0;
                if(session.getAttribute("customerID")!=null){
                    int customerID = Integer.parseInt(session.getAttribute("customerID").toString());
                    System.out.println("customerID: "+customerID);
                    if(customerID!=0){
                        Customer customer = new Customer(customerID);
                        ArrayList<Order> orderList = new ArrayList<Order>();
                            if(request.getParameter("orderID")!=null ){
                                orderID = Integer.parseInt(request.getParameter("orderID"));
                                System.out.println("orderID: "+orderID);
                            }
                            if(request.getParameter("timePeriod")!=null){
                                period = Integer.parseInt(request.getParameter("timePeriod"));
                                System.out.println("Period: "+period);
                            }
                            if(request.getParameter("productID")!=null){
                                productID = Integer.parseInt(request.getParameter("productID"));
                                System.out.println("productID"+productID);
                            }

                        if(customer.customerFindOrder(customerID, period, productID, orderID)!=null){
                            orderList = customer.customerFindOrder(customerID, period, productID, orderID);

                            out.println("<table align='center' border='2'  class='table table-hover'>");
                            out.println("<tr>");
                            out.println("<th>Order ID</th>");
                            out.println("<th>Customer ID</th>");
                            out.println("<th>Salesman ID</th>");
                            out.println("<th>Order Date</th>");
                            out.println("<th>Product ID</th>");   
                            out.println("<th>Price</th>");
                            out.println("<th>Quantity</th>");
                            out.println("</tr>");

                            for(Order order: orderList){
                                out.println("<tr>");
                                out.println("<td>"+order.getOrderID()+"</td>");
                                out.println("<td>"+order.getCustomerID()+"</td>");
                                out.println("<td>"+order.getSalesID()+"</td>");
                                out.println("<td>"+order.getDate()+"</td>");
                                out.println("<td>"+order.getProductID()+"</td>");
                                out.println("<td>"+order.getPrice()+"</td>");
                                out.println("<td>"+order.getQuantity()+"</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        }
                    }
                }
                
           
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <a href=\"index.html\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Main Page~</button>\n");
      out.write("            </a>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            \n");
      out.write("            <a href=\"login_business_customer.jsp\">\n");
      out.write("                        <button class=\"btn btn-large\" type=\"button\">Back to Login Page~</button>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
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
