
package com.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBContext {
   

    /**
     *
     * @return
     */
    
    
    
    public Connection getConnection(String serverName, String portNumber,String dbName,String userID,String password) throws  Exception{
        
//        InitialContext context = new InitialContext();
//        Context enviroment = (Context) context.lookup("java:/comp/evn");
//        String serverName = (String) enviroment.lookup("host");
//        System.out.println(serverName);
//        String dbName = (String) enviroment.lookup("dbName");
//        String portNumber = (String) enviroment.lookup("portNumber");
//        String userID = (String) enviroment.lookup("userID");
//        String password = (String) enviroment.lookup("password");
//        String serverName = "localhost";
//        String portNumber = "1433";
//        String dbName = "MyBlog";
//        String userID = "sa";
//        String password ="123456";
        String url="jdbc:sqlserver://"+ serverName+":" +portNumber +";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        return DriverManager.getConnection(url,userID,password);
    } 
}
