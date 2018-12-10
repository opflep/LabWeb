/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author dungndse05558
 */
public class InitContext {
    public static String host;
    public static String dbName;
    public static String portNumber;
    public static String password;
    public static String userID;
    public static String img;
    public static boolean connect = false;
    public static void getContext() throws NamingException{
        System.out.println("haha");
        InitialContext Context = new InitialContext();
        Context Enviroment = (Context) Context.lookup("java:/comp/env");
        dbName = (String) Enviroment.lookup("dbName");
        host = (String) Enviroment.lookup("host");
        portNumber = (String) Enviroment.lookup("portNumber");
        userID = (String) Enviroment.lookup("userID");
        password = (String) Enviroment.lookup("password");
        img = (String) Enviroment.lookup("img");
        connect =true;
    }
}
