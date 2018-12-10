package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Blog</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"pre-header\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <p class=\"news-name inner\">My Blogs</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <ul class=\"menu-list\">\n");
      out.write("                    <a href=\"ArticleController\"><li class=\"page");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${'Home' == page}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</li></a>\n");
      out.write("                    <a href=\"ContactController\"><li class=\"page");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${'Contact' == page}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Contact</li></a>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"content-container inner\">\n");
      out.write("                    <div class=\"contact\">\n");
      out.write("                        <fieldset>\n");
      out.write("                            <legend>All fields are required</legend>\n");
      out.write("                            <form action=\"ContactController\" method=\"POST\">\n");
      out.write("                                <table>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"field\">Name</td>\n");
      out.write("                                        <td><input type=\"text\" id=\"name\" name=\"name\" required /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"field\">Email</td>\n");
      out.write("                                        <td><input type=\"email\" id=\"email\" name=\"email\" required /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"field\">Phone</td>\n");
      out.write("                                        <td><input type=\"text\" id=\"phone\" name=\"phone\" required /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"field\">Company</td>\n");
      out.write("                                        <td><input type=\"text\" id=\"company\" name=\"company\" required /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"field\">Message</td>\n");
      out.write("                                        <td><textarea type=\"text\" id=\"message\" name=\"message\" required ></textarea></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                                <input type=\"submit\" id=\"submit\" value=\"Send\" />\n");
      out.write("                            </form>\n");
      out.write("                        </fieldset>\n");
      out.write("                        <p id=\"check\"></p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"aside\">\n");
      out.write("                        <div class=\"categories\">\n");
      out.write("                            <p class=\"heading\">Categories</p>\n");
      out.write("                            <ul>    \n");
      out.write("                                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setVar("item");
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categories}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                                    <li>\n");
            out.write("                                        <span><img src=\"");
            out.print(request.getContextPath());
            out.write("/img/img01.jpg\"></span>\n");
            out.write("                                        <a href=\"CategoryController?category=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.category}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.category}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</a>\n");
            out.write("                                    </li> \n");
            out.write("                                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer\">\n");
      out.write("            </div>\n");
      out.write("        </div> <!--container-->\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/contact.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
