package org.jastka4.pwr.idb.controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.repository.ItemRepository;
import org.jastka4.pwr.idb.repository.OrderRepository;
import org.jastka4.pwr.idb.repository.UserRepository;
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
    @Resource
    private UserRepository userRepository;
    @Resource
    private ItemRepository itemRepository;
    @Resource
    private OrderRepository orderRepository;

    List<Item> itemList;

    @GetMapping(value = "/")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemRepository.findAll());
//        System.out.println(itemList);
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
        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null){
            System.out.println("Zalogowany: " + user.getEmail());
            cart.setDate(LocalDateTime.now());
            cart.setValue(item.getPrice());
            cart.setClient(user);
            cartService.saveCart(cart);
        } else {
            return "redirect:/login";
        }


        return "redirect:/product?id=" + itemId;
    }
}
