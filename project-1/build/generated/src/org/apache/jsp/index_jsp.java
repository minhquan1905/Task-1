package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Task 1</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('form').submit(function () {\n");
      out.write("\n");
      out.write("                    var username = $('#username').val();\n");
      out.write("                    var password = $('#password').val();\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: \"LoginServlet\",\n");
      out.write("                        type: \"post\",\n");
      out.write("                        contentType: 'application/json',\n");
      out.write("                        dataType: 'json',\n");
      out.write("\n");
      out.write("                        data: JSON.stringify({\n");
      out.write("                            username: username,\n");
      out.write("                            password: password\n");
      out.write("                        }),\n");
      out.write("                        success: function (result) {\n");
      out.write("//                            if(result === \"success\"){\n");
      out.write("//                                alert(\"Login success!\");\n");
      out.write("//                            }\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Login Form</h2>\n");
      out.write("\n");
      out.write("        <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <label for=\"uname\"><b>Username</b></label>\n");
      out.write("                <input type=\"text\" placeholder=\"Enter Username\" id=\"username\" name=\"uname\" required>\n");
      out.write("\n");
      out.write("                <label for=\"psw\"><b>Password</b></label>\n");
      out.write("                <input type=\"password\" placeholder=\"Enter Password\" id=\"password\" name=\"psw\" required>\n");
      out.write("\n");
      out.write("                <button type=\"submit\" id=\"submit\">Login</button>\n");
      out.write("                <label>\n");
      out.write("                    <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
      out.write("                <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n");
      out.write("                <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
