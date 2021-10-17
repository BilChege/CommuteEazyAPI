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
public class CustomRoute {
    
    private int id;
    private String description;

    public CustomRoute(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public CustomRoute() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}