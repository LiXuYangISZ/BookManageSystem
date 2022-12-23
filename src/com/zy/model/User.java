/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zy.model;

/**
 * 用户类
 * @author 物竞天择适者生存
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String userid;

    public User(int id, String username, String password, String userid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userid = userid;
    }

    public User(String username, String password, String userid) {
        this.username = username;
        this.password = password;
        this.userid = userid;
    }
    

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
	}

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", userid=" + userid + '}';
    }
    
    
    
}
