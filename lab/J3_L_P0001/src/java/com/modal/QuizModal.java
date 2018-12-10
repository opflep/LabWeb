/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.Answer;
import com.entity.Quiz;
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
public class QuizModal {

    public ArrayList<Quiz> getQuiz(int n) throws SQLException {

        ArrayList<Quiz> list = new ArrayList<>();
        String query = "select top (?) * from quiz";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                String content = rs.getString("question");
                Quiz q = new Quiz(content);

                for (int i = 1; i <= 4; i++) {
                    String cont = rs.getString("option" + i);
                    int isTrue = rs.getInt("isOption" + i + "True");
                    q.getListAnswers().add(new Answer(i - 1, cont, isTrue));
                }
                list.add(q);
            }
        } catch (Exception ex) {
            Logger.getLogger(QuizModal.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Quiz> getQuizWithUsername(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Quiz> list = new ArrayList<>();
        try {
            String query = "select question, dataCreate from quiz where username=(?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                String content = rs.getString("question");
                String dataCreate = rs.getString("dataCreate");

                Quiz q = new Quiz(content, dataCreate);
                list.add(q);
            }
        } catch (Exception ex) {
            Logger.getLogger(QuizModal.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean AddQuizWithUsername(String username, Quiz quiz) throws SQLException {
        boolean rs = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String insert = "insert quiz values(?,?,?,?,?,?,?,?,?,?,?)";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(insert);
            ps.setString(1, username);
            ps.setString(2, quiz.getContent());

            for (int i = 1; i <= 4; i++) {
                Answer answer = quiz.getListAnswers().get(i - 1);
                ps.setString(1 + 2 * i, answer.getContent());
                ps.setInt(2 + 2 * i, answer.getIsTrue());
            }
            ps.setString(11, quiz.getDataCreate());
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
