/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.Quiz;
import com.modal.QuizModal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

/**
 *
 * @author vietnkse04597
 */
public class DoMakeQuiz extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String username = session.getAttribute("LoginUser").toString();

            String question = request.getParameter("txtAreaQuestion");
            String date = getDate();
            Quiz quiz = getQuizFromRequest(request, question, date);

            QuizModal quizModal = new QuizModal();
            quizModal.AddQuizWithUsername(username, quiz);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/MakeQuiz.jsp");
        }
    }

    Quiz getQuizFromRequest(HttpServletRequest request, String question, String date) {
        Quiz quiz = new Quiz(question, date);
        for (int i = 1; i <= 4; i++) {
            String txtArea = request.getParameter("txtArea" + i);
            boolean isContentTrue = (request.getParameter("cbx" + i) != null);
            int isTrue = 1;
            if (!isContentTrue) {
                isTrue = 0;
            }
            quiz.addNewAnswer(txtArea, isTrue);
        }
        return quiz;
    }

    String getDate() {
        Calendar cal = Calendar.getInstance();
        // TODO: change date format
        String[] monthInYear = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int day = cal.getTime().getDay();
        String month = monthInYear[cal.getTime().getMonth()];
        int year = cal.getTime().getYear() + 1900;
        return day + "-" + month + "-" + year;
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
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DoMakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DoMakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
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
