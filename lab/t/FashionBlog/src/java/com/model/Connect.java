/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Chu Anh
 */
public class Connect {

    public Connection getConnection() throws Exception {
        Connection con = null;
        try {
            InitialContext intContext = new InitialContext();
            Context evnContext = (Context) intContext.lookup("java:comp/env");
            String serverName = (String) evnContext.lookup("local");
            String dbName = (String) evnContext.lookup("dbName");
            String portNumber = (String) evnContext.lookup("portNumber");
            String userID = (String) evnContext.lookup("userID");
            String password = (String) evnContext.lookup("passWord");
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getInterfaces();
            con = DriverManager.getConnection(url, userID, password);
        } catch (Exception e) {
            throw e;
        }
        return con;
    }
}
