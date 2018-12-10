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
import com.context.InitContext;
import static controllers.CategoryBlogController.category2;
import dao.AllDAO;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
/**
 *
 * @author dungndse05558
 */
@WebServlet(name = "blogController", urlPatterns = {"/blogController"})
public class BlogController extends HttpServlet {
    String serverName ;
    String portNumber;
    String dbName;
    String userID;
    String password;
    String category="begin";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        List<Post> p = new ArrayList<>();
        List<Post> p2 = new ArrayList<>();
        if ( com.context.InitContext.connect==false){
            try {
                com.context.InitContext.getContext();
            } catch (NamingException ex) {
                Logger.getLogger(BlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        serverName=com.context.InitContext.host;
        portNumber=com.context.InitContext.portNumber;
        dbName=com.context.InitContext.dbName;
        userID=com.context.InitContext.userID;
        password=com.context.InitContext.password;
           
        int size =  (new dao.AllDAO()).getSize();;
        
        String page = "Home";
        
        p = (new dao.AllDAO()).get3Blogs(1, 3);
    
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
            
            category2= p.get(0).getCategory();
            request.setAttribute("category2", category2);
            request.setAttribute("page", page);
            request.setAttribute("blogs1", p);
            request.setAttribute("blogs2",p2);
            
            RequestDispatcher view =  request.getRequestDispatcher("./home.jsp");
            view.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
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

    
