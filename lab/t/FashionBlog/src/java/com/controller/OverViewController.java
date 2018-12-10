/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Blog;
import com.entity.DataPagination;
import com.entity.NumberPagination;
import com.model.GetData;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chu Anh
 */
public class OverViewController extends HttpServlet {

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
                String text = (String) request.getParameter("currentPage");
                ArrayList<Blog> arrBlog;
                int currentPage = Integer.parseInt(text);
                int totalPage;
                ArrayList<NumberPagination> arrNumPagin = new ArrayList<NumberPagination>();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
                LocalDate local;
                int conditionMonth = 0;
                int conditionYear = 0;
                DataPagination pagin;
                ArrayList<DataPagination> arrDataPagin = new ArrayList<>();
                if (currentPage > 0) {
                    GetData controllerData = new GetData();
                    totalPage = controllerData.getTotalPages();
                    arrBlog = controllerData.getDataList(currentPage);
                    if (!arrBlog.isEmpty()) {
                        for (int j = 1; j <= totalPage; j++) {
                            if (j == currentPage) {
                                arrNumPagin.add(new NumberPagination(1, Integer.toString(j)));
                            } else {
                                arrNumPagin.add(new NumberPagination(2, Integer.toString(j)));
                            }
                        }
                        for (int i = 0; i < arrBlog.size(); i++) {
                            java.sql.Date dateMonthYear = arrBlog.get(i).getDate();
                            local = dateMonthYear.toLocalDate();
                            if (conditionMonth == local.getMonthValue()
                                    && conditionYear == local.getYear()) {
                                pagin = new DataPagination(arrBlog.get(i).getFashionID(),
                                        arrBlog.get(i).getFashionName(), arrBlog.get(i).getPushDate(), 2);
                                arrDataPagin.add(pagin);
                            } else {
                                conditionMonth = local.getMonthValue();
                                conditionYear = local.getYear();
                                String txtYear = String.valueOf(conditionYear);
                                String monthYear = local.getMonth() + " - " + txtYear;
                                pagin = new DataPagination(0, monthYear, "Date", 1);
                                arrDataPagin.add(pagin);
                                pagin = new DataPagination(arrBlog.get(i).getFashionID(),
                                        arrBlog.get(i).getFashionName(), arrBlog.get(i).getPushDate(), 2);
                                arrDataPagin.add(pagin);
                            }
                        }
                    }
                    request.setAttribute("arrPagination", arrDataPagin);
                    request.setAttribute("arrNumPagination", arrNumPagin);
                    request.getRequestDispatcher("/Web-Content/OverView.jsp").forward(request, response);
                }
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
