package com.hld.controller;
import com.hld.entities.User;
import com.hld.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther:HLD
 * @Date:2019/4/2
 * @Description:com.hld.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username
            , @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        User user = userService.getUserByNameAndPw(username, password);
        if(!StringUtils.isEmpty(user)){
            System.out.println(username);
            session.setAttribute("username",username);
            return "redirect:/index_page";
        }
        else{
            map.put("msg","账号或密码错误");
            System.out.println(("alert('此用户名已存在，请重新输入！');"));
            return "07-login";
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user,HttpSession session){
            if(StringUtils.isEmpty(userService.getUserByNameAndPw(user.getUsername(),user.getPassword()))){
                userService.insertUser(user);
                session.setAttribute("username",user.getUsername());
                return "redirect:/index_page";
            }else{
                return "redirect:/register_page";
            }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/index_page";
    }
    @RequestMapping("/toedituser")
    public String toeditUser(HttpSession session, Model model){
        String  username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        model.addAttribute("user",user);
        return "user/update";
    }
    @RequestMapping("/update")
    public String update(User user){
        userService.updateUser(user);
        return  "redirect:/index_page";
    }
}
