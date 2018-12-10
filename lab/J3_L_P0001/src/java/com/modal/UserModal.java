/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vietnkse04597
 */
public class UserModal {

    public ArrayList<User> getAllUser() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        try {

            String query = "select username, password, email, usertype from users";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int usertype = rs.getInt("usertype");

                User u = new User(username, password, email, usertype);
                list.add(u);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserModal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            if (ps != null && ps.isClosed() == false) {
                ps.close();
            }
            if (conn != null && conn.isClosed() == false) {
                conn.close();
            }
        }

        return list;
    }

    // return 1: usertype is teacher
    // return 0: usertype is student
    // return -1: login fail
    public int CheckExistUser(String username, String password) throws SQLException {
        ArrayList<User> users = getAllUser();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u.getUsertype();
            }
        }
        return -1;
    }

    public boolean AddNewUser(String username, String password, String email, int usertype) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean rs = false;
        try {
            String insert = "insert users(username,password, email, usertype) values(?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(insert);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, usertype);

            rs = (ps.executeUpdate() != 0);

        } catch (Exception ex) {
            Logger.getLogger(UserModal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null && ps.isClosed() == false) {
                ps.close();
            }
            if (conn != null && conn.isClosed() == false) {
                conn.close();
            }
        }
        return rs;
    }

}
