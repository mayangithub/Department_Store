package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.BusinessCustomer;
import edu.pitt.store.Customer;
import edu.pitt.store.Security;

public final class register_005fbusiness_005fcustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    session.setAttribute("businesscustomer", null);
    session.setAttribute("customerID", null);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Business Customer Register Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Welcome to INFSCI 2710 Department Store</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"register_business_customer.jsp\">\n");
      out.write("                <label>Email: &nbsp;</label>\n");
      out.write("                <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"mail@domain.com\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Password: &nbsp;</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Name: &nbsp;</label>\n");
      out.write("                <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Real Name\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Address: &nbsp;</label>\n");
      out.write("                <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Company Name: &nbsp;</label>\n");
      out.write("                <input name=\"companyName\" type=\"text\" placeholder=\"Company Name\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Category: &nbsp;</label>\n");
      out.write("                <input type=\"text\" name='category' placeholder=\"Company Category\" required class=\"form-control\"/><br><br>\n");
      out.write("                <label>Income: &nbsp;</label>\n");
      out.write("                <input type='number' name=\"income\" placeholder=\"Numeric Value\" min=\"100\" max=\"100000000\" required class='form-control'/> Thousand<br>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <button class=\"btn btn-large\" type=\"submit\" value=\"Submit\">Submit</button>\n");
      out.write("                <button class=\"btn btn-large\" type=\"reset\" value=\"Reset\">Reset</button>\n");
      out.write("                <a href=\"login_business_customer.jsp\">\n");
      out.write("                        <button class=\"btn btn-large\" type=\"button\">Existing Business Customer Login~</button><p>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

                String email = null;
                String password =null;
                String name = null;
                String address = null;
                String companyName = null;
                String category = null;
                int income = 0;
                

                    Security security = new Security();
                    
                     if(request.getParameter("email")!=null && request.getParameter("password")!=null && request.getParameter("name")!=null
                        &&request.getParameter("address")!=null && request.getParameter("companyName")!=null && request.getParameter("category")!=null
                        && request.getParameter("income")!=null ){
                        email = request.getParameter("email");
                        if(security.findExistingCustomer(email)){
                            out.println("<script language='javascript'>alert('You are already a customer. Please Login~')</script>");
                            
                        }else{
                            password = request.getParameter("password");
                            name = request.getParameter("name");
                            address = request.getParameter("address");
                            companyName = request.getParameter("companyName");
                            category = request.getParameter("category");
                            income = Integer.parseInt(request.getParameter("income"));

                            Customer newCustomer = new Customer(email, password, "Business", name, address);
                            int customerID = security.findCustomerByEmail(email);
                            System.out.println(customerID);
                            BusinessCustomer newBusinessCustomer = new BusinessCustomer(customerID, companyName, category, income);
                            System.out.println(newBusinessCustomer.getCustomerID());
                            System.out.println(newBusinessCustomer.getCategory());
                            session.setAttribute("businesscustomer", newBusinessCustomer);
                            session.setAttribute("customerID", customerID);
                            out.println("<script language='javascript'>alert('Congratulations! Registered successfully! Please Login~')</script>");
                        }
                    }
            
      out.write("\n");
      out.write("        \n");
      out.write("            <br><br>\n");
      out.write("            <div align=\"center\">\n");
      out.write("            <a href=\"index.html\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Main Page~</button>\n");
      out.write("            </a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("        \n");
      out.write("        \n");
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
