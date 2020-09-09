package com.movie.pojo;

/**
 * @Author: acer
 * @Date: 2020/9/7 09:50
 * @Description:
 */
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String user_date;

    public User(Integer user_id, String username, String password, String user_date) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_date = user_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getUser_date() {
        return user_date;
    }

    public void setUser_date(String user_date) {
        this.user_date = user_date;
    }
}
