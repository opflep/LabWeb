/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
@WebServlet(name = "CategoryBlogController", urlPatterns = {"/CategoryBlogController"})
public class CategoryBlogController extends HttpServlet {

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
            out.println("<title>Servlet CategoryBlogController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryBlogController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    static String category2;
    static String category;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Post> p = new ArrayList<>();
        List<Post> p2 = new ArrayList<>();
        int currentPage= 1;
        String category1 = null;
        try{
            category1 = request.getParameter("category");
            currentPage= Integer.parseInt(request.getParameter("currentPage"));
        
        }catch(Exception e ){
            
        }
       
        if ( !category1.equalsIgnoreCase("fullArticle")){
            category2=category1; 
        }
        
        String category3 = category2.substring(0,1).toUpperCase()+ category2.substring(1);
        category2=category3;
        category =category1;
        int size = getSize(category);
        System.out.println("this is " + category2);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("category",category);
        
        int totalPage = (int) Math.ceil(size/3)+1;
        int indexDes = currentPage*3;
        request.setAttribute("totalPage", totalPage);
        
        
        if ( category.equals("fullArticle")){
            p = (new dao.AllDAO()).get3Blogs(indexDes-2, indexDes);
            
        }else{
            p = (new dao.AllDAO()).get3BlogsByCategory(category,indexDes-2, indexDes);
            
        }
            
        if (p.size() >=3){
            p2.add(p.get(1));
            p2.add(p.get(2));
            p.remove(1);
            p.remove(1);
        }
        else if ( p.size() == 2){
            p2.add(p.get(1));
            p.remove(1);
        }
            
            
            request.setAttribute("category2", category2);
            request.setAttribute("blogs1", p);
            request.setAttribute("blogs2",p2);
            
            RequestDispatcher view =  request.getRequestDispatcher("./categoryBlog.jsp");
            view.forward(request, response);
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
    public int getSize(String category){
        int size ;
        if (category.equalsIgnoreCase("art") ||category.equalsIgnoreCase("beauty") ||category.equalsIgnoreCase("car") ||category.equalsIgnoreCase("food") ){
            size = (new dao.AllDAO()).getSizeByCategory(category);
        }else{
            size = (new dao.AllDAO()).getSize();
        }
        return size;
    }
}
