/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author vietnkse04597
 */
public class User {

    private String username;
    private String password;
    private String email;
    private int usertype;

    public User(String username, String password, String email, int usertype) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getUsertype() {
        return usertype;
    }

}
