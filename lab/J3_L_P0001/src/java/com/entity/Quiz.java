/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.ArrayList;

/**
 *
 * @author vietnkse04597
 */
public class Quiz {

    private String content;

    private ArrayList<Answer> listAnswers;

    private String dataCreate;

    public Quiz(String content) {
        this.content = content;
        this.listAnswers = new ArrayList<Answer>();
    }

    public Quiz(String content, String dataCreate) {
        this.content = content;
        this.dataCreate = dataCreate;
        this.listAnswers = new ArrayList<Answer>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ArrayList<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }

    public String getDataCreate() {
        return dataCreate;
    }

    public void addNewAnswer(String content, int isTrue) {
        listAnswers.add(new Answer(listAnswers.size(), content, isTrue));
    }

}
