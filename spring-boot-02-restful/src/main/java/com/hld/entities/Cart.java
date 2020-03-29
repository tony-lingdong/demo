package com.hld.entities;

import java.math.BigDecimal;

public class Cart {
    private int id;
    private int user_id;
    private int flower_id;
    private String flower_name;
    private int flower_number;
    private BigDecimal flower_price;
    private String flower_pic;

    public String getFlower_pic() {
        return flower_pic;
    }

    public void setFlower_pic(String flower_pic) {
        this.flower_pic = flower_pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public int getFlower_number() {
        return flower_number;
    }

    public void setFlower_number(int flower_number) {
        this.flower_number = flower_number;
    }

    public BigDecimal getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(BigDecimal flower_price) {
        this.flower_price = flower_price;
    }
}
