package com.hld.controller;

import com.hld.entities.User;
import com.hld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

@Controller
public class Manager_UserController {
    @Autowired
    UserService userService;
    @PostMapping("/manager")
    public String managerlogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,  Map<String,Object> map){
        if(username.equals("hulingdong")&&password.equals("123456"))
        return "dashboard";
        else {
            map.put("msg","账号或者密码错误");
            return "login_manager";
        }
    }
    @GetMapping("/users")
    public String  getUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "emp/list";
    }
    //跳转到修改用户页面
    @GetMapping("/user_update_page/{id}")
    public String toUpdatePage(@PathVariable("id") int id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute(user);
        return "emp/update";
    }
    @PostMapping("/user_update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    //来到用户添加页面
    @GetMapping("/user_insert_page")
    public String toInsertPage(){
        return "emp/add";
    }
    @PostMapping("/user_insert")
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/users";
    }
}
