package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_t_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_t_choose;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_t_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_t_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_t_when_test.release();
    _jspx_tagPool_t_choose.release();
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\">\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <img src=\"./top_box.gif\" />\n");
      out.write("        \n");
      out.write("        <ul class=\"HeaderUl\">\n");
      out.write("            <li> <a href=\"Home.jsp\" > Home </a> </li>\n");
      out.write("            <li> <a href=\"TakeQuiz.jsp\"> Take Quiz </a> </li>\n");
      out.write("            <li> <a href=\"MakeQuiz.jsp\"> Make Quiz </a> </li>\n");
      out.write("            <li> <a href=\"/J3_L_P0001/DoManagerQuiz\"> Manager Quiz </a> </li>\n");
      out.write("                ");
      if (_jspx_meth_t_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
      if (_jspx_meth_t_choose_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_t_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_t_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_t_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_t_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_t_choose_0.setParent(null);
    int _jspx_eval_t_choose_0 = _jspx_th_t_choose_0.doStartTag();
    if (_jspx_eval_t_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_t_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_t_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_t_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_choose.reuse(_jspx_th_t_choose_0);
      return true;
    }
    _jspx_tagPool_t_choose.reuse(_jspx_th_t_choose_0);
    return false;
  }

  private boolean _jspx_meth_t_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_t_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_t_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_t_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_t_when_0.setPageContext(_jspx_page_context);
    _jspx_th_t_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_choose_0);
    _jspx_th_t_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LoginUser != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_t_when_0 = _jspx_th_t_when_0.doStartTag();
    if (_jspx_eval_t_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li> <a href=\"/J3_L_P0001/DoLogout\"> Log out </a> </li>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_t_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_when_test.reuse(_jspx_th_t_when_0);
      return true;
    }
    _jspx_tagPool_t_when_test.reuse(_jspx_th_t_when_0);
    return false;
  }

  private boolean _jspx_meth_t_choose_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_t_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_t_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_t_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_t_choose_1.setParent(null);
    int _jspx_eval_t_choose_1 = _jspx_th_t_choose_1.doStartTag();
    if (_jspx_eval_t_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_t_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_t_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_t_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_choose.reuse(_jspx_th_t_choose_1);
      return true;
    }
    _jspx_tagPool_t_choose.reuse(_jspx_th_t_choose_1);
    return false;
  }

  private boolean _jspx_meth_t_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_t_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_t_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_t_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_t_when_1.setPageContext(_jspx_page_context);
    _jspx_th_t_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_choose_1);
    _jspx_th_t_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LoginUser == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_t_when_1 = _jspx_th_t_when_1.doStartTag();
    if (_jspx_eval_t_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div>\n");
        out.write("                    <form action=\"DoLogin\" method=\"post\">\n");
        out.write("\n");
        out.write("                        <table>\n");
        out.write("\n");
        out.write("                            <tr>\n");
        out.write("                                <th colspan=\"2\" class=\"HomeLoginDecoration\">\n");
        out.write("                                    Login Form\n");
        out.write("                                </th>\n");
        out.write("                            </tr>\n");
        out.write("                            \n");
        out.write("                            <tr>\n");
        out.write("                                <th colspan=\"2\">\n");
        out.write("                                    <br>\n");
        out.write("                                </th>\n");
        out.write("                            </tr>\n");
        out.write("\n");
        out.write("                            <tr>\n");
        out.write("                                <td class=\"HomeTextDecoration\"> User Name: </td>\n");
        out.write("                                <td>\n");
        out.write("                                    <input type=\"text\" name =\"txtUsername\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtUsername}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                </td>                        \n");
        out.write("                            </tr>\n");
        out.write("\n");
        out.write("                            <tr>\n");
        out.write("                                <td class=\"HomeTextDecoration\"> Password: </td>\n");
        out.write("                                <td>\n");
        out.write("                                    <input type=\"password\" name =\"txtPassword\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtPassword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                </td>\n");
        out.write("\n");
        out.write("                            </tr>\n");
        out.write("\n");
        out.write("                            <tr>\n");
        out.write("                                <td></td>\n");
        out.write("                                <td class=\"HomeTextResult\">\n");
        out.write("                                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LoginResult}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                </td>\n");
        out.write("\n");
        out.write("                            </tr>\n");
        out.write("\n");
        out.write("                            <tr>\n");
        out.write("                                <td>\n");
        out.write("                                </td>\n");
        out.write("                                <td>\n");
        out.write("                                    <input type=\"submit\" value=\"Sign in\" name=\"btnSignin\" />\n");
        out.write("                                    <a href=\"Registration.jsp\" class=\"HomeTextDecoration\"> Register </a>\n");
        out.write("                                </td>\n");
        out.write("                            </tr>\n");
        out.write("\n");
        out.write("                        </table>\n");
        out.write("                    </form>\n");
        out.write("                </div>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_t_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_when_test.reuse(_jspx_th_t_when_1);
      return true;
    }
    _jspx_tagPool_t_when_test.reuse(_jspx_th_t_when_1);
    return false;
  }
}
