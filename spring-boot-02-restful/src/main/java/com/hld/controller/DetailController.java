package com.hld.controller;

import com.hld.entities.Flower;
import com.hld.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.controller
 * @version: 1.0
 */
@Controller
public class DetailController {
    @Autowired
    FlowerService flowerService;
    @RequestMapping("/detail/{id}")
    public String flowerDetail(@PathVariable("id") Integer id, Model model){
        Flower flower = flowerService.getFlowerById(id);
        model.addAttribute("flower",flower);
        return "product-details";
    }
}
