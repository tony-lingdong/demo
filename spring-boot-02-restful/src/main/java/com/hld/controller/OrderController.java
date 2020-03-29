package com.hld.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hld.entities.*;
import com.hld.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    FlowerService flowerService;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @RequestMapping("/toOrder")
    public String order(Model model, @RequestParam("flower") int[] flower
            , @RequestParam("flower_number") int[] flower_number,
                        HttpSession session){
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        List<Address> addresses = addressService.getAllAddress(user.getId());
        ArrayList<MyFlower> flowers = new ArrayList<>();
        int a = 15;
        BigDecimal price = new BigDecimal(a);
        for (int i=0;i<flower.length;i++){
            int id = flower[i];
            Flower flower1 = flowerService.getFlowerById(id);
            MyFlower myFlower = new MyFlower();
            myFlower.setName(flower1.getName());
            myFlower.setDetails(flower1.getDetails());
            myFlower.setPic(flower1.getPic());
            myFlower.setPrice(flower1.getPrice());
            myFlower.setNumber(flower_number[i]);
            myFlower.setId(flower1.getId());
            BigDecimal number = new BigDecimal(flower_number[i]);
            myFlower.setTotalprice(flower1.getPrice().multiply(number));
            price=price.add(myFlower.getTotalprice());
            flowers.add(myFlower);
        }
        System.out.println(price);
        model.addAttribute("flowers",flowers);
        model.addAttribute("price",price);
        model.addAttribute("address",addresses);
        session.setAttribute("flowers",flowers);
        return "order.html";
    }
    @RequestMapping("/createOrder")
    public String createOrder(@RequestParam("price") BigDecimal price,
                              @RequestParam("address_id") int address_id,
                              HttpSession session){
        ArrayList<MyFlower> flowers  = (ArrayList<MyFlower>) session.getAttribute("flowers");
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        cartService.delete(user.getId());
        Order order = new Order();
        order.setAddress_id(address_id);
        order.setName(user.getUsername());
        order.setPhone(user.getPhone());
        order.setUser_id(user.getId());
        order.setTotal_price(price);
        order.setStatus(0);
        orderService.InsertOrder(order);
        System.out.println(order);
        for (int i = 0;i<flowers.size();i++){
            OrderItems orderItems = new OrderItems();
            orderItems.setFlower_id(flowers.get(i).getId());
            orderItems.setName(flowers.get(i).getName());
            orderItems.setNumber(flowers.get(i).getNumber());
            orderItems.setOrder_id(order.getId());
            orderItems.setPrice(flowers.get(i).getPrice());
            orderItems.setTotal_price(flowers.get(i).getTotalprice());
            orderItems.setPic(flowers.get(i).getPic());
            orderService.InsertOrderItems(orderItems);
        }
        return "redirect:/myorder";
    }
    @RequestMapping("/myorder")
    public String myorder(HttpSession session,Model model){
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        List<Order> orders= orderService.getAllOrder(user.getId());
        ArrayList<MyOrder> myOrders = new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            List<OrderItems> orderItems = orderService.getAllOrderItems(orders.get(i).getId());
            Address address = addressService.getAllAddressById(orders.get(i).getAddress_id());
            MyOrder myOrder = new MyOrder();
            myOrder.setOrderItems(orderItems);
            myOrder.setAddress_id(orders.get(i).getAddress_id());
            myOrder.setName(orders.get(i).getName());
            myOrder.setTotal_price(orders.get(i).getTotal_price());
            myOrder.setUser_id(orders.get(i).getUser_id());
            myOrder.setId(orders.get(i).getId());
            myOrder.setPhone(orders.get(i).getPhone());
            myOrder.setStatus(0);
            myOrder.setAddresses(address);
            myOrders.add(myOrder);
        }
        model.addAttribute("orders",myOrders);
        return "myorder";
    }
}
