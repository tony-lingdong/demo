package com.hld.service.impl;

import com.hld.entities.Cart;
import com.hld.mapper.CartMapper;
import com.hld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public List<Cart> getAllCart(int user_id) {
        return cartMapper.getAllCart(user_id);
    }

    @Override
    public void insertCart(Cart cart) {
        cartMapper.insertCart(cart);
    }

    @Override
    public Cart existOrNot(int user_id, int flower_id) {
        return cartMapper.existOrNot(user_id,flower_id);
    }

    @Override
    public void updateCart(Cart cart) {
         cartMapper.updateCart(cart);
    }

    @Override
    public void delete(int id) {
        cartMapper.delete(id);
    }
}
