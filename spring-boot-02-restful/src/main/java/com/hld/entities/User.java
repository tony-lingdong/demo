package com.hld.entities;


import com.alibaba.druid.support.monitor.annotation.MTable;
import com.sun.javafx.beans.IDProperty;

@MTable(name = "tb_user")
public class User {
    private int id;
    private String username;
    private String password;
    private String city;
    private String email;
    private String realname;
    private String phone;
    private int sex;
    private String nickname;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getRealname() {
        return realname;
    }

    public String getPhone() {
        return phone;
    }

    public int getSex() {
        return sex;
    }

    public String getNickname() {
        return nickname;
    }
}
