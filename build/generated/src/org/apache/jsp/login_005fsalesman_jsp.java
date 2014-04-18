package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.store.Salesman;
import edu.pitt.store.Security;

public final class login_005fsalesman_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    session.setAttribute("salesman", null);
    session.setAttribute("salesID", null);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Salesman Login Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Welcome to INFSCI 2710 Department Store</h1>\n");
      out.write("        <h3>Your status is: <em>Salesman</em>.</h3>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form method=\"post\" action=\"login_salesman.jsp\">\n");
      out.write("                <label>Email: \n");
      out.write("                    <input type=\"email\" id=\"username\" name=\"username\"  class=\"form-control\" placeholder=\"mail@domain.com\" required/></label><br><br>\n");
      out.write("                <label>Password: \n");
      out.write("                    <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Password\" required /></label><br><br>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <button class=\"btn btn-large\" type=\"submit\" value=\"Submit\">Submit</button>\n");
      out.write("                <button class=\"btn btn-large\" type=\"reset\" value=\"Reset\">Reset</button>\n");
      out.write("                \n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            String email = "";
            String password = "";
            
            if(request.getParameter("username")!=null && request.getParameter("password")!=null){
                email = request.getParameter("username");
                password = request.getParameter("password");
                Security security = new Security();
                Salesman salesman = security.validateSalesmanLogin(email, password);
                if(salesman!=null){
                    session.setAttribute("salesman", salesman);
                    int salesID = security.findSalesmanByEmail(email);
                    session.setAttribute("salesID", salesID);
                    out.println("<script language='javascript'>alert('Login successfully~')</script>");
                    response.sendRedirect("salesman_action.jsp");
                }else{
                    out.println("<script language='javascript'>alert('Login failed.')</script>");
                }
            }
        
        
        
        
        
      out.write("\n");
      out.write("        \n");
      out.write("            <br><br>\n");
      out.write("            <div align=\"center\">\n");
      out.write("            <a href=\"index.html\">\n");
      out.write("                <button class=\"btn btn-large\" type=\"button\">Back to Main Page~</button>\n");
      out.write("            </a> \n");
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
