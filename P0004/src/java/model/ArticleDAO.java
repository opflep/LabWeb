/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhgqse04763
 */

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO() {
    }
    
    // Get article by ID
    public Article getArticleById(int id) {
        Article temp = null;
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * FROM [ArticleTBL] WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                temp = new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("author"),
                        rs.getTimestamp("time"),
                        rs.getString("image"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return temp;
    }
    
    // Get the top {top} lastest articles
    public ArrayList<Article> getTopLastArticles(int top) {
        ArrayList<Article> temp = new ArrayList<>();
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * " +
                "FROM [ArticleTBL] " +
                "ORDER BY time DESC";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setMaxRows(top);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                temp.add(new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("author"),
                        rs.getTimestamp("time"),
                        rs.getString("image")));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return temp;
    }
    
    // Get articles by Title
    public ArrayList<Article> getArticlesByTitle(String title) {
        ArrayList<Article> temp = new ArrayList<>();
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();
            
            String sql = "SELECT * FROM [ArticleTBL] WHERE title like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                temp.add(new Article(rs.getInt("id"), 
                        rs.getString("title"), 
                        rs.getString("content"),
                        rs.getString("author"),
                        rs.getTimestamp("time"),
                        rs.getString("image")));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return temp;
    }
}
