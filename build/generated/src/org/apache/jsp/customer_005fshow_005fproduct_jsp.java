package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import edu.pitt.store.Product;

public final class customer_005fshow_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if(session.getAttribute("homecustomer")==null && session.getAttribute("businessCustomer")==null){
        response.sendRedirect("index.html");
    }else if(session.getAttribute("productList")==null){
        response.sendRedirect("home_customer_action.jsp");
    }
    
    
    

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer View Product Result</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Here is the Result</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table class=\"table table-striped, table table-hover\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product name</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("                    <th>Inventory</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    ArrayList<Product> matchedProductList = new ArrayList<Product>();
                    matchedProductList = (ArrayList<Product>)session.getAttribute("productList");
                    for(Product product: matchedProductList){
                        out.println("<tr>");
                        out.println("<td>"+product.getProductID()+"</td>");
                        out.println("<td>"+product.getName()+"</td>");
                        out.println("<td>"+product.getCategory()+"</td>");
                        out.println("<td>"+product.getInventory()+"</td>");
                        out.println("<td>"+product.getPrice()+"</td>");
                        out.println("</tr>");
                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("            </table>\n");
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
