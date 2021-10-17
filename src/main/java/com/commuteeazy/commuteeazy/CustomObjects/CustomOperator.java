/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.CustomObjects;

/**
 *
 * @author BilChege
 */
public class CustomOperator {
    
    private int id;
    private String operatorName;
    private String email;
    private String phone;

    public CustomOperator(int id, String operatorName, String email, String phone) {
        this.id = id;
        this.operatorName = operatorName;
        this.email = email;
        this.phone = phone;
    }

    public CustomOperator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }    
}