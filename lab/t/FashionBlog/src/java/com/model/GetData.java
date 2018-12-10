                                                    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.AboutMe;
import com.entity.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chu Anh
 */
public class GetData {

    //get link image from file context
    public String getImageLink() throws Exception {
        String returnLink = "";
        try {
            InitialContext intContext = new InitialContext();
            Context evnContext = (Context) intContext.lookup("java:comp/env");
            returnLink = (String) evnContext.lookup("imageLink");
        } catch (Exception e) {
            throw e;
        }
        return returnLink;
    }

    //get the list blog (about 4 blog) order by push date
    public ArrayList<Blog> getListBlog() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Blog> arrBlog = new ArrayList<>();
        try {
            int fashionID;
            int type;
            String fashionName;
            String content;
            String picture = "";
            String localPicture = getImageLink();
            java.sql.Date date;
            String squery = "select TOP 4 * from fashionBlog fas order by fas.fashionPushDate DESC";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while (rs.next()) {
                fashionID = rs.getInt("fashionID");
                type = rs.getInt("type");
                fashionName = rs.getString("fashionName");
                content = rs.getString("content");
                picture = localPicture + rs.getString("picture");
                date = rs.getDate("fashionPushDate");
                arrBlog.add(new Blog(fashionID, type, fashionName, content, picture, date));
            }
         /*them code */   ps.close();
            rs.close();
            closeConnection(con, rs, ps);
        } catch (Exception e) {
            System.out.println(e);
            closeConnection(con, rs, ps);
            throw e;
        }

        return arrBlog;
    }

    //get total pages
    public int getTotalPages() throws Exception {
        int totalPage = 0;
        int totalRecord = 0;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String squery = "select count (*)as TotalRecord from  fashionBlog ";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRecord = rs.getInt("TotalRecord");
            }
            if (totalRecord % 3 != 0) {
                totalPage = (totalRecord / 3) + 1;
            } else {
                totalPage = totalRecord / 3;
            }
            closeConnection(con, rs, ps);
            return totalPage;
        } catch (Exception e) {
            closeConnection(con, rs, ps);
            throw e;
        }

    }

    //get data list for each pagination 
    public ArrayList<Blog> getDataList(int currentPage) throws Exception {
        int totalPage = 0;
        int totalRecord = 0;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Blog> returnList = new ArrayList<>();
        String localPicture = getImageLink();
        Blog bl;
        try {
            String squery = "select * from (" 
                    + "SELECT f.fashionID, f.type, f.fashionName, "
                    + "f.fashionPushDate, f.picture, f.content, ROW_NUMBER() "
                    + "OVER(ORDER BY f.fashionPushDate) ID "
                    + "FROM fashionBlog as f ) as FF Where ID between "
                    + "(? - 1) * 3 + 1 and ? * 3;";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            ps.setInt(1, currentPage);
            ps.setInt(2, currentPage);
            rs = ps.executeQuery();
            String picture = "";
            while (rs.next()) {
                picture = localPicture + rs.getString("picture");
                bl = new Blog(rs.getInt("fashionID"), rs.getInt("type"), rs.getString("fashionName"),
                        rs.getString("content"), picture, rs.getDate("fashionPushDate"));
                returnList.add(bl);
            }
            closeConnection(con, rs, ps);
            return returnList;
        } catch (Exception e) {
            closeConnection(con, rs, ps);
            throw e;
        }

    }

    //get blog by ID for Detail Blog
    public Blog getBlogByID(int id) throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Blog bl = null;
        String localPicture = getImageLink();
        String picture = "";
        try {
            String squery = "select * from fashionBlog fas where fas.fashionID = ?";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()) {
                picture = localPicture + rs.getString("picture");
                bl = new Blog(rs.getInt("fashionID"), rs.getInt("type"), rs.getString("fashionName"),
                        rs.getString("content"), picture, rs.getDate("fashionPushDate"));
            }
            closeConnection(con, rs, ps);
            return bl;
        } catch (Exception e) {
            throw e;
        }
    }

    //insert message from user to database
    public int insertMessage(String name, String mail, String mess) throws Exception{
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Blog bl = null;
//        String localPicture = getImageLink();
//        String picture = "";
        try {
            String squery = "insert into message values (?, ?, ?)";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, mess);
            int z = ps.executeUpdate();
            closeConnection(con, rs, ps);
            return z;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    //get infor about me 
    public AboutMe getAboutMe() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        AboutMe bl = null;
        String localPicture = getImageLink();
        String picture = "";
        try {
            String squery = "select * from aboutMe";
            Connect dbc = new Connect();
            con = dbc.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while (rs.next()) {
                picture = localPicture + rs.getString("picture");
                bl = new AboutMe(rs.getString("name"), rs.getInt("age"), rs.getString("description"),
                        picture);
            }
            closeConnection(con, rs, ps);
            return bl;
        } catch (Exception e) {
            throw e;
        }
    }

    //handle close connect 
    public void closeConnection(Connection con, ResultSet rs, PreparedStatement ps) throws Exception {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
