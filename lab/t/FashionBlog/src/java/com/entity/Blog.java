/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Chu Anh
 */
public class Blog {
    private int fashionID;
    private int type;
    private String fashionName;
    private String content;
    private String picture ;
    private java.sql.Date date ;
    private String pushDate ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");

    public Blog(int fashionID, int type, String fashionName, String content, String picture, Date date) {
        this.fashionID = fashionID;
        this.type = type;
        this.fashionName = fashionName;
        this.content = content;
        this.picture = picture;
        this.date = date;
        pushDate = sdf.format(date);
    }

    public int getFashionID() {
        return fashionID;
    }

    public void setFashionID(int fashionID) {
        this.fashionID = fashionID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFashionName() {
        return fashionName;
    }

    public void setFashionName(String fashionName) {
        this.fashionName = fashionName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPushDate() {
        return pushDate;
    }

    public void setPushDate(String pushDate) {
        this.pushDate = pushDate;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
    
    
}
