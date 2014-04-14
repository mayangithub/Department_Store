package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customer_005faction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Customer Operation Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body align=\"center\">\n");
      out.write("        <h1>Browse product</h1>\n");
      out.write("        <div>\n");
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
      out.write("        <br><br><br><br>\n");
      out.write("        \n");
      out.write("        <h1>Search Product</h1>\n");
      out.write("        <div>\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("            <p>Product name:\n");
      out.write("                <input type=\"text\" name=\"productName\" placeholder=\"Product Name\"/>（vague search）</p>\n");
      out.write("            <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br><br><br><br>\n");
      out.write("        <h1>Search Product</h1>\n");
      out.write("        <div>\n");
      out.write("            <form method=\"get\" action=\"\">\n");
      out.write("                <p>Product ID: \n");
      out.write("                <input type=\"text\" value=\"\" name=\"productID\" placeholder=\"Product ID\" /></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\"  />\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <br><br><br><br>\n");
      out.write("        <h1>Search for Orders</h1>\n");
      out.write("        <div>\n");
      out.write("            <form method=\"get\" action=\"\" >\n");
      out.write("                <p>Time period: \n");
      out.write("                <select name=\"timePeriod\">\n");
      out.write("                    <option value=\"30\">30 Days</option>\n");
      out.write("                    <option value=\"60\">60 Days</option>\n");
      out.write("                    <option value=\"90\">60 Days</option>\n");
      out.write("                    <option value=\"1000\"> All </option>\n");
      out.write("                </select></p>\n");
      out.write("                <p>Product ID: \n");
      out.write("                    <input value=\"\" name=\"productID\" type=\"text\" placeholder=\"Product ID\"/></p>\n");
      out.write("                <p>Order ID: \n");
      out.write("                    <input type=\"text\" name=\"orderID\" value=\"\" placeholder=\"Order ID\" /></p>\n");
      out.write("                <input type=\"submit\" value=\"Submit Query\" />\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
