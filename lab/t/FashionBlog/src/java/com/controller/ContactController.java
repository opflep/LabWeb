/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.Validate.Validate;
import com.model.GetData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chu Anh
 */
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
            try {
                GetData dataController = new GetData();
                Validate valController = new Validate();
//                if string notify == 1 is mean doesn't have message
                String isNotify = "1";
                String notify = "";
                String name = null, mail = null, mess = null;
                name = request.getParameter("txtName");
                mail = request.getParameter("txtMail");
                mess = request.getParameter("txtArea");
                if (valController.checkBlank(name) == true) {
                    notify += " Name cannot blank !" + "<br>";
                    isNotify = "2";
                } 
                if (valController.checkBlank(mail) == true) {
                    notify += " Mail can not blank !" + "<br>";
                    isNotify = "2";
                } 
                if (valController.checkBlank(mess) == true) {
                    notify += " Meassage can not blank !" + "<br>";
                    isNotify = "2";
                } 
                if (valController.checkMail(mail) == false) {
                    notify += " Mail invalid !" + "<br>";
                    isNotify = "2";
                }
                if (isNotify == "1") {
                    //insert to database
                    if (dataController.insertMessage(name, mail, mess) != 0) {
                        isNotify = "3";
                        notify = "Thanks you your message!";
                    }
                } else if (isNotify == "2") {
                    request.setAttribute("name", name);
                    request.setAttribute("mail", mail);
                    request.setAttribute("mess", mess);
                }
                request.setAttribute("isNotify", isNotify);
                request.setAttribute("notify", notify);
                request.getRequestDispatcher("/Web-Content/Contact.jsp").forward(request, response);
            } catch (Exception e) {
                request.getRequestDispatcher("/Web-Content/ErrorPage.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
