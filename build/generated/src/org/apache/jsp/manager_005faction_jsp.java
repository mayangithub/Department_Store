package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("        </div>\n");
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
      out.write("        </div>\n");
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
      out.write("        <br><br><br><br><br><br>\n");
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
