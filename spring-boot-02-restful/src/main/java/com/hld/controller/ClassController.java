package com.hld.controller;

import com.hld.entities.Flower;
import com.hld.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    FlowerService flowerService;
    @RequestMapping("/search/{id}")
    public String search(@PathVariable int id, Model model){
        List<Flower> flowers = flowerService.getFlowerByClass_Id(id);
        model.addAttribute("flower",flowers);
        return "products";
    }
    @RequestMapping("/low/{low}/high/{high}")
    public String searchByPrice(@PathVariable BigDecimal low, @PathVariable BigDecimal high, Model model){
        List<Flower> flowers = flowerService.getFlowerByPrice(low, high);
        model.addAttribute("flower",flowers);
        return "products";
    }
}
