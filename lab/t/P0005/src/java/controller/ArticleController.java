/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import entity.Category;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ArticleDAO;
import model.CategoryDAO;

public class ArticleController extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            // Get category list
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> categories = categoryDAO.getCategories();
            request.setAttribute("categories", categories);

            // Get top 3 lastest articles
            ArticleDAO articleDAO = new ArticleDAO();
            ArrayList<Article> topLastArticles = articleDAO.getTopLastArticles(3);
            request.setAttribute("topLastArticles", topLastArticles);

            request.setAttribute("page", "Home");

            // Get the requested article by ID
            // If ID is not requested, return 0. It means requesting the lastest article
            String idString = request.getParameter("id");
            int articleId = (idString == null) ? 0 : Integer.parseInt(idString);
            Article article = null;
            if (articleId == 0) {
                article = (topLastArticles.isEmpty()) ? null : topLastArticles.get(0);
            } else {
                article = articleDAO.getArticleById(articleId);
            }
            if (article == null) {
                response.sendRedirect("error.jsp");
                return;
            };
            article.setContent(article.getContent().replaceAll("\n", "</p><p>"));
            request.setAttribute("article", article);

            // Display view
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp?error=" + ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
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
