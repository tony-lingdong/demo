package com.hld.entities;

import java.math.BigDecimal;

public class MyFlower extends Flower{
    private int number;
    private BigDecimal totalprice;
    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}
