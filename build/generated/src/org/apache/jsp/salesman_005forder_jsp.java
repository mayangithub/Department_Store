package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.Salesman;
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    if(session.getAttribute("salesman")==null){
        response.sendRedirect("login_salesman.jsp");
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Salesman Order Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Salesman, You can make an order</h1>\n");
      out.write("        <div align=\"center\" > \n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                <table border=\"2\" class=\"table table-striped, table table-hover\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Purchase Option</th>\n");
      out.write("                        <th>Enter</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Product ID</td>\n");
      out.write("                        <td><input type=\"number\" required name=\"productID\" placeholder=\"Product ID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Quantity</td>\n");
      out.write("                        <td><input type=\"number\" min=\"1\" name=\"quantity\" placeholder=\"Numeric Amount\" required/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Customer ID</td>\n");
      out.write("                        <td><input type=\"number\" required name=\"customerID\" placeholder=\"Customer ID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Salesman ID</td>\n");
      out.write("                        <td>");
      out.print(((Salesman) session.getAttribute("salesman")).getSalesID());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" value=\"Submit Order\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        ");

            if(session.getAttribute("salesman")!=null){
                if(request.getParameter("productID")!=null && request.getParameter("quantity")!=null && request.getParameter("customerID")!=null 
                        && session.getAttribute("salesman")!=null){
                    int productID = Integer.parseInt(request.getParameter("productID"));
                    Product product = new Product(productID);
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    if(product.getInventory()<quantity){
                        out.println("<script language='javascript'>alert('Inventory not enough.')</script>");
                    }else{
                        int customerID = Integer.parseInt(request.getParameter("customerID"));
                        int salesID = ((Salesman) session.getAttribute("salesman")).getSalesID();
                        session.setAttribute("salesID", salesID);
                        Salesman salesman = (Salesman) session.getAttribute("salesman");
                        salesman.placeOrder(salesID, productID, customerID, quantity);


                        out.println("<table border='2'  align = 'center' class='table table-striped, table table-hover'>");
                        out.println("<tr>");
                        out.println("<th>Purchase Option</th>");
                        out.println("<th>Enter</th>");
                        out.println("</tr><tr><td>Product ID</td>");
                        out.println("<td>"+productID+"</td></tr><tr>");
                        out.println("<td>Quantity</td><td>"+quantity+"</td></tr>");
                        out.println("<tr><td>Customer ID</td><td>"+customerID+"</td></tr><tr>");
                        out.println("<td>Salesman ID</td>");
                        out.println("<td>"+salesID+"</td></tr></table>");
                    }
                    
                    if(product.getInventory()<100){
                        out.println("<script language='javascript'>alert('Inventory less than 100.')</script>");
                    }
                    
                    
                }
                
                
            }
            
        

        
      out.write("\n");
      out.write("        \n");
      out.write("            <br><br>\n");
      out.write("            <div align=\"center\">\n");
      out.write("            <a href=\"index.html\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Main Page~</button>\n");
      out.write("            </a>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            <a href=\"salesman_action.jsp\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Salesman Search Page~</button>\n");
      out.write("            </a>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            \n");
      out.write("            <a href=\"login_salesman.jsp\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Login Page~</button>\n");
      out.write("            </a>\n");
      out.write("                </div>\n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <br><br>\n");
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
