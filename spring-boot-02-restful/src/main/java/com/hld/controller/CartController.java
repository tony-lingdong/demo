package com.hld.controller;

import com.hld.entities.Cart;
import com.hld.entities.Flower;
import com.hld.entities.User;
import com.hld.service.CartService;
import com.hld.service.FlowerService;
import com.hld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
        @Autowired
        CartService cartService;
        @Autowired
        FlowerService flowerService;
        @Autowired
        UserService userService;
        @RequestMapping("/addcart/{id}")
        public String addCart(HttpSession session,@PathVariable int id){
            String username = (String) session.getAttribute("username");
            System.out.println(username+"加入购物车");
            Flower flower = flowerService.getFlowerById(id);
            User user = userService.getUserByName(username);
                if(username!=null) {
                    Cart cart = cartService.existOrNot(user.getId(),flower.getId());
                    if(cart!=null) {
                        int number = cart.getFlower_number() +1;
                        cart.setFlower_number(number);
                        System.out.println(number);
                        cartService.updateCart(cart);

                    }else{
                        Cart cart1 = new Cart();
                        cart1.setUser_id(user.getId());
                        cart1.setFlower_name(flower.getName());
                        cart1.setFlower_id(flower.getId());
                        cart1.setFlower_price(flower.getPrice());
                        cart1.setFlower_number(1);
                        cart1.setFlower_pic(flower.getPic());
                        cartService.insertCart(cart1);
                    }
                }
            return "redirect:/index_page";
        }
        @RequestMapping("/delete/{id}")
        public String deleteCart(@PathVariable int id){
            cartService.delete(id);
            return "redirect:/cart";
        }
}
