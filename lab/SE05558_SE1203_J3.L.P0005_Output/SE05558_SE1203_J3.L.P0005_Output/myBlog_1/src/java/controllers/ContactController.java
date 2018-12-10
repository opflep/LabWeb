/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.context.InitContext;
import dao.AllDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unities.Post;

/**
 *
 * @author dungndse05558
 */
@WebServlet(name = "contactController", urlPatterns = {"/contactController"})
public class ContactController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contactController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contactController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    String error="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("page", "Contact");
            RequestDispatcher view =  request.getRequestDispatcher("./contact.jsp");
            view.forward(request, response);
            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String company = request.getParameter("company");
        String message = request.getParameter("message");
        boolean rightContact=false;
        String regName = "[a-zA-Z\\s]+";
        String regEmail="^[\\w.+\\-]+@gmail\\.com$";
        String regPhone ="\\d+";
        error = "";
        System.out.println(name);
        if (name.equalsIgnoreCase("")){
            error="enter name field,";
        }else if ( !name.matches(regName)){
            error += "name only contain number \n";
        }
        
        if (email.equalsIgnoreCase("")){
            error+="enter email field, ";
        }else if ( !email.matches(regEmail)){
            error+="email is not valid \n";            
        }
        
        if (phone.equalsIgnoreCase("")){
            error+="enter phone field, ";
        }else if ( !phone.matches(regPhone)){
            error += "phone only contain number\n";
        }
        
        if (company.equalsIgnoreCase("")){
            error+= "enter company field, ";
        }
        
        if (message.equalsIgnoreCase("")){
            error += "enter message field";
        }
         
        if ( error.equalsIgnoreCase("")){
            new dao.AllDAO().contact(name, email, company, message, phone);
            error="submitted successfully";
        }
        
        
        
        
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("company", company);
        request.setAttribute("message", message);
        System.out.println(error);
        request.setAttribute("error", error);
        RequestDispatcher view =  request.getRequestDispatcher("./contact.jsp");
            view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
