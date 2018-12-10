/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import com.context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import unities.Post;
/**
 *
 * @author dungndse05558
 */
public class AllDAO {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    public AllDAO (){
        
    }
    
    public List<Post>  AllBlog(){
        String query = "select * from blog";
        List<Post> Posts = new ArrayList<Post>();
        try {
            connection = (new DBContext()).getConnection(com.context.InitContext.host, 
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            ps= connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setBrief(rs.getString("brief"));
                p.setContent(rs.getString("content"));
                p.setDatecreated(rs.getDate("dateceated"));
                p.setCategory(rs.getString("category"));
                p.setName(rs.getString("title"));
                p.setImg(rs.getString("img"));
                Posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Posts;
    }
    
    public void contact(String name,String email,String company, String message,String phone){
        String query = "insert into contact (name,email,phone,company,sent_message) values (?,?,?,?,?)";
        try {
            connection = (new DBContext()).getConnection(com.context.InitContext.host,
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            name = name.trim();
            email= email.trim();
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, company);
            ps.setString(5, message);
            
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Post>  get3BlogsByCategory(String category,int from,int to){
        String query = "select * from (select *, ROW_NUMBER() over (order by[dateceated] desc ) as Seq from blog where category = ? ) t where Seq between ? and ?";
        List<Post> Posts = new ArrayList<Post>();
        try {
            connection = (new DBContext()).getConnection(com.context.InitContext.host, 
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            ps= connection.prepareStatement(query);
            ps.setString(1,category);
            ps.setInt(2,from);
            ps.setInt(3, to);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setBrief(rs.getString("brief"));
                p.setContent(rs.getString("content"));
                p.setDatecreated(rs.getDate("dateceated"));
                p.setCategory(rs.getString("category"));
                p.setName(rs.getString("title"));
                p.setImg(rs.getString("img"));
                Posts.add(p);
            }
        }
        catch (Exception e) {
            }finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Posts;
    }
    
    public List<Post>  BlogById(int id){
        String query = "select * from blog where id =?";
        List<Post> Posts = new ArrayList<Post>();
        try {
            connection = (new DBContext()).getConnection(com.context.InitContext.host, 
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            ps= connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setBrief(rs.getString("brief"));
                p.setContent(rs.getString("content"));
                p.setDatecreated(rs.getDate("dateceated"));
                p.setCategory(rs.getString("category"));
                p.setName(rs.getString("title"));
                p.setImg(rs.getString("img"));
                Posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Posts;
    }
    
    public List<Post>  get3Blogs(int from , int to){
        String query = "select * from (select *, ROW_NUMBER() over (order by[dateceated] desc ) as Seq from blog ) t where Seq between ? and ?";
        List<Post> Posts = new ArrayList<Post>();
        try {
            connection = (new DBContext()).getConnection(com.context.InitContext.host, 
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            ps= connection.prepareStatement(query);
            ps.setInt(1,from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setBrief(rs.getString("brief"));
                p.setContent(rs.getString("content"));
                p.setDatecreated(rs.getDate("dateceated"));
                p.setCategory(rs.getString("category"));
                p.setName(rs.getString("title"));
                p.setImg(rs.getString("img"));
                Posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Posts;
    }
    
    public int getSize(){
        String query ="Select COUNT(*) from blog";
        int size = 0;
        try{
            connection = (new DBContext()).getConnection(com.context.InitContext.host,
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                size = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }
    
    public int getSizeByCategory(String category){
        String query ="Select COUNT(*) from blog where category = ?";
        int size = 0;
        try{
            connection = (new DBContext()).getConnection(com.context.InitContext.host,
                    com.context.InitContext.portNumber, com.context.InitContext.dbName,
                    com.context.InitContext.userID, com.context.InitContext.password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1,category);
            rs = ps.executeQuery();
            while(rs.next()){
                size = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                closeResult(rs);
                closeState(ps);
                closeConn(connection);
            } catch (SQLException ex) {
                Logger.getLogger(AllDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }
    
    public void closeConn(Connection conn2) throws SQLException{
        if ( !conn2.isClosed() && conn2!=null){
            conn2.close();
        }
    }
    
    public void closeResult(ResultSet rs2) throws SQLException{
        if ( !rs2.isClosed() && rs2!=null){
            rs2.close();
        }
    }
    
    public void closeState(PreparedStatement ps2) throws SQLException{
        if ( !ps2.isClosed() && ps2!=null){
            ps2.close();
        }
    }
}
