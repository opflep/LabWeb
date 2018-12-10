/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author Chu Anh
 */
public class NumberPagination {
    int type  ; //values 1 is actice and 2 is deactive
    String number ;

    public NumberPagination(int type, String number) {
        this.type = type;
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

  
    
}
