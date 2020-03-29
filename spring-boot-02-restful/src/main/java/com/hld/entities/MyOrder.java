package com.hld.entities;

import java.util.List;

public class MyOrder extends Order{
    private List<OrderItems> orderItems;
    private Address addresses;


    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
