package org.jastka4.pwr.idb.controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.service.CartService;
import org.jastka4.pwr.idb.service.ItemService;
import org.jastka4.pwr.idb.service.UserService;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Resource
    private UserService userService;
    @Resource
    private ItemService itemService;
    @Resource
    private CartService cartService;

    List<Item> itemList;
//    Item item;

    @GetMapping(value = "/")
    public ModelAndView hello() {
//        List<Item> itemList = null;
        ModelAndView modelAndView = new ModelAndView();
        itemList = itemService.findAll();
        modelAndView.addObject("items", itemList);
        System.out.println(itemList);
//        for (Item i :
//                itemList) {
//            modelAndView.addObject("item" + i.getId(), i);
//        }
        modelAndView.setViewName("productListingPage");
        return modelAndView;
    }

    @RequestMapping(value = "/product", params = {"id"})
    public ModelAndView showProduct(@RequestParam(value = "id") int itemId) {
        ModelAndView modelAndView = new ModelAndView();
        Item item = itemService.findItemById(itemId);
        modelAndView.addObject("itemId", item.getId());
        modelAndView.addObject("itemName", item.getName());
        modelAndView.addObject("itemDescription", item.getDescription());
        modelAndView.addObject("itemPrice", "$" + item.getPrice());
        modelAndView.addObject("itemAmount", item.getAmount());
        modelAndView.setViewName("productDisplayPage");
        return modelAndView;
    }

    @PostMapping(value = "/product", params = {"id"})
    public String addToCart(@RequestParam(value = "id") int itemId){
        Item item = itemService.findItemById(itemId);
        Cart cart = new Cart();
        cart.setDate(LocalDateTime.now());
        cart.setValue(item.getPrice());
//        cart.setClient(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        System.out.println(" -------- " + SecurityContextHolder.getContext().getAuthentication().getName());
        cartService.saveCart(cart);

        return "redirect:/product?id=" + itemId;
    }
//    @RequestMapping(value = "/product", method = RequestMethod.GET)
//    public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response){
//        ModelAndView modelAndView = new ModelAndView();
//        Item item = itemService.findItemById(Integer.parseInt(request.getParameter("id")));
//        Cart cart = new Cart();
//        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//        cart.setValue(item.getPrice());
//
//
//        modelAndView.addObject("itemName", item.getName());
//        modelAndView.addObject("itemDescription", item.getDescription());
//        modelAndView.addObject("itemPrice", "$" + item.getPrice());
//        modelAndView.addObject("itemAmount", "Ilość w magazynie: " + item.getAmount());
//        modelAndView.setViewName("productDisplayPage");
//        return modelAndView;
//    }

    @GetMapping(value = "/admin/home")
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
