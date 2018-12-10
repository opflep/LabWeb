/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chu Anh
 */
public class Validate {

    //validate blank if blank return true else false
    public boolean checkBlank(String s) {
        if (s.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //validate mail
    public boolean checkMail(String s) {
        String mail = s.trim();
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(mail);
        return m.matches();
    }
}
