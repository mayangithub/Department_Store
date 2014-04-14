package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.HomeCustomer;
import edu.pitt.store.Customer;
import edu.pitt.store.Security;

public final class register_005fhome_005fcustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

                String email = "";
                String password ="";
                String name = "";
                String address = "";
                String gender = "";
                String marriage = "";
                int age = 0;
                int income = 0;
                
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                    name = request.getParameter("name");
                    address = request.getParameter("address");
                    gender = request.getParameter("gender");
                    age = Integer.parseInt(request.getParameter("age").toString());
                    marriage = request.getParameter("marriage");
                    income = Integer.parseInt(request.getParameter("income").toString());

                    Security security = new Security();
                    if(security.findExistingCustomer(email)){
                        out.println("<script language='javascript'>alert('You are already a customer. Please Login~')</script>");
                        response.sendRedirect("login_home_customer.jsp");
                    }else{
                        Customer newCustomer = new Customer(email, password, "Home", name, address);
                        HomeCustomer newHomeCustomer = new HomeCustomer(newCustomer.getCustomerID(), age, gender, marriage, income);
                        out.println("<script language='javascript'>alert('Congratulations! Registered successfully! Please Login~')</script>");
                        response.sendRedirect("login_home_customer.jsp");
                    }
                
                
                
            
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Customer Register Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Welcome to INFSCI 2710 Department Store</h1><br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"register_home_customer.jsp\">\n");
      out.write("                <p>Email: \n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"mail@domain.com\" value=\"\"/></p><br>\n");
      out.write("                <p>Password:\n");
      out.write("                    <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" value=\"\"/></p><br>\n");
      out.write("                <p>Name:\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Real Name\" value=\"\" /></p><br>\n");
      out.write("                <p>Address: \n");
      out.write("                    <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" value=\"\"/></p><br>\n");
      out.write("                <p>Gender: \n");
      out.write("                    <input type=\"radio\" name='gender' value=\"Male\"> Male  \n");
      out.write("                    <input type='radio' name='gender' value=\"Female\"> Female</p><br>\n");
      out.write("                <p>Age: \n");
      out.write("                    <input type='text' id='age' name=\"age\" placeholder='Age' value=\"0\"/></p><br>\n");
      out.write("                <p>Marriage Status: \n");
      out.write("                    <input type='radio' value='married' name=\"marriage\"> Married   \n");
      out.write("                    <input type='radio' name='marriage' value=\"single\"> Single</p><br>\n");
      out.write("                <p>Income: \n");
      out.write("                    <input type='number' name=\"income\" placeholder=\"Numeric Value\" value=\"\"/></p><br>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <button class=\"btn btn-large\" type=\"submit\" value=\"Submit\">Submit</button>\n");
      out.write("                <button class=\"btn btn-large\" type=\"reset\" value=\"Reset\">Reset</button>\n");
      out.write("                <a href=\"login_home_customer.jsp\">\n");
      out.write("                    <button class=\"btn btn-large\" type=\"button\">Existing Home Customer Login~</button>\n");
      out.write("                </a>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            \n");
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
