/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

/**
 *
 * @author vietnkse04597
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vietnkse04597
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        InitialContext init = new InitialContext();
        Context environmentContext = (Context) init.lookup("java:/comp/env");
        String url = (String) environmentContext.lookup("myConnectionURL");
        String userID = (String) environmentContext.lookup("username");
        String password = (String) environmentContext.lookup("password");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) throws Exception {
        DBContext db = new DBContext();
        db.getConnection();
    }
}
