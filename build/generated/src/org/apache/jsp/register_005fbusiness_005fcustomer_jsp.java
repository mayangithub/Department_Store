package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Business Customer Register Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Welcome to INFSCI 2710 Department Store</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"register_home_customer.jsp\">\n");
      out.write("                <p>Email</p>\n");
      out.write("                <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"mail@domain.com\" /><br>\n");
      out.write("                <p>Password</p>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" /><br>\n");
      out.write("                <p>Name</p>\n");
      out.write("                <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Real Name\" /><br>\n");
      out.write("                <p>Address</p>\n");
      out.write("                <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" /><br>\n");
      out.write("                <p>Company Name</p>\n");
      out.write("                <input name=\"companyName\" type=\"text\" placeholder=\"Company Name\" /><br>\n");
      out.write("                <p>Category</p>\n");
      out.write("                <input type=\"text\" name='category' placeholder=\"Company Category\" /><br>\n");
      out.write("                <p>Income</p>\n");
      out.write("                <input type='text' name=\"income\" placeholder=\"Numeric Value\" /><br>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <button class=\"btn btn-large\" type=\"submit\" value=\"Submit\">Submit</button>\n");
      out.write("                <button class=\"btn btn-large\" type=\"reset\" value=\"Reset\">Reset</button>\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\" value=\"redirect\" onclick=\"\">Existing Member Login~</button>\n");
      out.write("\n");
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
