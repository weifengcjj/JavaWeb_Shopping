package com.ygj.Model;

import java.util.Date;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class User {
    private int id;
    private String user;
    private String password;
    private String  datetime;
    private String email;

    public User() {
    }

    public User(String user, String password,String email) {
        this.user = user;
        this.password = password;
        this.email=email;
    }

    public User(String user, String password, String datetime,String email) {
        this.user = user;
        this.password = password;
        this.datetime = datetime;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
