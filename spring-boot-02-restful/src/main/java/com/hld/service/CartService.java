package com.hld.service;

import com.hld.entities.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCart(int user_id);
    void insertCart(Cart cart);
    Cart existOrNot(int user_id,int flower_id);
    void updateCart(Cart cart);
    void delete(int id);
}
