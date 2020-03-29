package com.hld.controller;

import com.hld.entities.Flower;
import com.hld.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.controller
 * @version: 1.0
 */
@Controller
public class Manager_FlowerController {
    @Autowired
    FlowerService flowerService;
    @RequestMapping("/flowers")
    public String getAllFlowers(Model model,int pageNum, int pageSize){
        List<Flower> flowers= flowerService.getAllFlowers();
        model.addAttribute("flowers",flowers);
        return "flower/list";
    }
}
