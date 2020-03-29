package com.hld.controller;

import com.github.pagehelper.PageHelper;
import com.hld.entities.Cart;
import com.hld.entities.Flower;
import com.hld.entities.PageBean;
import com.hld.entities.User;
import com.hld.service.CartService;
import com.hld.service.FlowerService;
import com.hld.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/2
 * @Description:com.hld.controller
 * @version: 1.0
 */
@Controller
public class PageController {
    @Autowired
    FlowerService flowerService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @RequestMapping("/index_page")
    public String toindex(){
        return "index";
    }
    @RequestMapping("/login_page")
    public String tologin(){
        return "07-login";
    }
    @RequestMapping("/register_page")
    public String toregister(){
        return "register";
    }
    @RequestMapping("/login_manager_page")
    public String tomanagerlogin(){
        return "login_manager";
    }
    @RequestMapping("/details")
    public String todetails(){
        return "product-details";
    }
    @RequestMapping("/products")
    public String toproducts(Model model, @Param("pageNum") Integer pageNum, Integer pageSize){
        if(pageNum==null)
            pageNum=1;
        if (pageSize==null)
            pageSize=12;
        PageHelper.startPage(pageNum,pageSize);
        try {
            List<Flower> flowers = flowerService.getAllFlowers();
            int count = flowerService.countNum();
            PageBean pageBean = new PageBean(pageNum,pageSize,count);
            model.addAttribute("pageInfo",pageBean);
            model.addAttribute("flower",flowers);
        }finally {
            PageHelper.clearPage();
        }
        return "products";
    }
    @RequestMapping("/cart")
    public String tocart(Model model, HttpSession session){
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        List<Cart> allCart = cartService.getAllCart(user.getId());
        model.addAttribute("carts",allCart);
        return "cart";
    }
    @RequestMapping("/order")
    public String toOrderPage(){
        return "order.html";
    }
    @RequestMapping("/toAddress")
    public String toAddress(){
        return "order/address";
    }
    @RequestMapping("/tomyorder")
    public String tomyorder(){
        return "myorder";
    }
}
