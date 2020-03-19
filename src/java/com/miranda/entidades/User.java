/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miranda.entidades;

/**
 *
 * @author miran
 */
public class User {
    
    private int id;
    private String username;
    private String description;
    
    public User(){
        
    }

    public User(int id, String username, String description) {
        this.id = id;
        this.username = username;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void serDescription(String description) {
        this.description = description;
    }
    
}
