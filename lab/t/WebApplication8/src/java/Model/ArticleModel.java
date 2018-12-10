/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DBaccess;
import Entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Alpha 69
 */
public class ArticleModel {

    DBaccess db;

    public ArticleModel() throws NamingException {
        db = new DBaccess();
    }

    public List<Article> getArticlesFromTo(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Article> articles = new ArrayList<>();
        String query = "select * from (\n"
                + "select *, ROW_NUMBER() over (order by id desc) as rownumber \n"
                + "from Artical)\n"
                + "as Artical\n"
                + "where Artical.rownumber >= ? and\n"
                + "Artical.rownumber <= ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("Title"));
                a.setType(rs.getString("Type"));
                a.setImglink(db.getResource() + rs.getString("imglink"));
                a.setShortDescription(rs.getString("SortDescription"));
                a.setFulldescription(rs.getString("LongDescription"));
                articles.add(a);
            }
            db.closeConnection(rs, ps, conn);
            return articles;
        } catch (Exception ex) {
            articles = null;
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }
//    get intro and about
    public Article getArticle(String Type) throws Exception {
        Article a = new Article();
        String query = "select * from Artical where Type=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Type);
            rs = ps.executeQuery();
            while (rs.next()) {

                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("Title"));
                a.setType(rs.getString("Type"));
                a.setImglink(db.getResource() + rs.getString("imglink"));
                a.setShortDescription(rs.getString("SortDescription"));
                a.setFulldescription(rs.getString("LongDescription"));
            }
            db.closeConnection(rs, ps, conn);
            return a;
        } catch (Exception ex) {
            a = null;
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }
//get sale or no-sale products
    public Article getArticleByType(String Type) throws Exception {
        Article a = new Article();
        String query = "select * from Intros where Type=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Type);
            rs = ps.executeQuery();
            while (rs.next()) {

                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("Title"));
                a.setType(rs.getString("Type"));
                a.setImglink(db.getResource() + rs.getString("imglink"));
                a.setShortDescription(rs.getString("SortDescription"));
                a.setFulldescription(rs.getString("LongDescription"));
            }
            db.closeConnection(rs, ps, conn);
            return a;
        } catch (Exception ex) {
            a = null;
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }
// get data for detail
    public Article getArticleByID(int id) throws Exception {
        Article a = new Article();
        String query = "select * from Artical where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("Title"));
                a.setType(rs.getString("Type"));
                a.setImglink(db.getResource() + rs.getString("imglink"));
                a.setShortDescription(rs.getString("SortDescription"));
                a.setFulldescription(rs.getString("LongDescription"));
            }
            db.closeConnection(rs, ps, conn);
            return a;
        } catch (Exception ex) {
            a = null;
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }

//        get totalrow to paging
    public int getTotalRows() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) from Artical";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
            db.closeConnection(rs, ps, conn);
            return rows;
        } catch (Exception ex) {
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }

}
