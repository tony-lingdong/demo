package com.hld.controller;

import com.hld.entities.Address;
import com.hld.entities.User;
import com.hld.service.AddressService;
import com.hld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @RequestMapping("/insertAddress")
    public String insertAddress(Address address, HttpSession session){
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        Address address1 = new Address();
        address1.setUser_id(user.getId());
        address1.setAddress(address.getAddress());
        address1.setPhone(address.getPhone());
        address1.setIs_default(address.isIs_default());
        address1.setName(address.getName());
        System.out.println(address1);
        addressService.InsertAddress(address1);
        return "/order";
    }
}
