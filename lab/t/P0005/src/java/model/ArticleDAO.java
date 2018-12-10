/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Article;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArticleDAO {

    public ArticleDAO() {
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
    // Get article by ID
    public Article getArticleById(int id) throws SQLException {
        Article temp = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * FROM [ArticleTBL] WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                temp = new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("image"),
                        new Category(rs.getString("category")),
                        sdf.format(rs.getDate("date")));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return temp;
    }
    
    // Get the top {top} lastest articles
    public ArrayList<Article> getTopLastArticles(int top) throws SQLException {
        ArrayList<Article> temp = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * " +
                "FROM [ArticleTBL] " +
                "ORDER BY date DESC";
            
            statement = connection.prepareStatement(sql);
            statement.setMaxRows(top);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                temp.add(new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("image"),
                        new Category(rs.getString("category")),
                        sdf.format(rs.getDate("date"))));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return temp;
    }
    
    // Get articles by Category
    public ArrayList<Article> getArticlesByCategory(String category) throws SQLException {
        ArrayList<Article> temp = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * FROM [ArticleTBL] WHERE category = ? ORDER BY date DESC";
             statement = connection.prepareStatement(sql);
            statement.setString(1, category);
             rs = statement.executeQuery();
            
            while (rs.next()) {
                temp.add(new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("image"),
                        new Category(rs.getString("category")),
                        sdf.format(rs.getDate("date"))));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return temp;
    }
}
