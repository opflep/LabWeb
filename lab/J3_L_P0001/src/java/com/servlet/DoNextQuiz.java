/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.Answer;
import com.entity.Quiz;
import com.modal.QuizModal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vietnkse04597
 */
public class DoNextQuiz extends HttpServlet {

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

            CheckQuiz(request, response);

            HttpSession session = request.getSession();

            long startTime = (long) session.getAttribute("startTime");

            ArrayList<Quiz> listQuiz = (ArrayList<Quiz>) session.getAttribute("listQuiz");
            long remainSecond = listQuiz.size() * 60 - (Calendar.getInstance().getTime().getTime() - startTime) / 1000;

            int indexQuiz = (int) session.getAttribute("indexQuiz");
            indexQuiz++;

            String endingTime = (String) request.getParameter("endingTime");

            if (indexQuiz == listQuiz.size() || endingTime != null || remainSecond <= 0) {
                int point = (int) session.getAttribute("point");
                int quantityOfQuiz = (int) session.getAttribute("quantityOfQuiz");

                double playerPoint = 0;
                if (quantityOfQuiz != 0) {
                    playerPoint = ((double) point / quantityOfQuiz) * 10;
                }

                session.setAttribute("playerScore", playerPoint);
                session.setAttribute("playerScorePercent", (int) playerPoint * 10 );
                session.setAttribute("indexQuiz", null);
                session.setAttribute("quiz", null);
                session.setAttribute("minute", 0);
                session.setAttribute("second", 0);
            } else {
                session.setAttribute("indexQuiz", indexQuiz);
                session.setAttribute("quiz", listQuiz.get(indexQuiz));
                session.setAttribute("minute", remainSecond / 60);
                session.setAttribute("second", remainSecond % 60);
            }

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/TakeQuiz.jsp");
        }
    }

    void CheckQuiz(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        ArrayList<Quiz> listQuiz = (ArrayList<Quiz>) session.getAttribute("listQuiz");

        int indexQuiz = (int) session.getAttribute("indexQuiz");
        if (indexQuiz < 0) {
            return;
        }
        ArrayList<Answer> q = listQuiz.get(indexQuiz).getListAnswers();
        int point = (int) session.getAttribute("point");

        int numberOfChosen = 0;
        boolean checkTrueAnswer = false;
        for (int i = 0; i < 4; i++) {
            String cbx = request.getParameter("option" + i);

            if (cbx != null && q.get(i).getIsTrue() == 1) {
                checkTrueAnswer = true;
            }

            if (cbx != null) {
                numberOfChosen++;
            }
        }

        if (numberOfChosen == 1 && checkTrueAnswer == true) {
            point++;
        }
        session.setAttribute("point", point);
        System.out.println("point = " + point);
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
