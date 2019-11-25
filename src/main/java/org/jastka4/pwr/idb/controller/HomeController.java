package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.service.ItemService;
import org.jastka4.pwr.idb.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private UserService userService;
    @Resource
    private ItemService itemService;

    @GetMapping(value = "/")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productListingPage");
        return modelAndView;
    }

    @GetMapping(value = "/product/{itemId}/")
    public ModelAndView showProduct(@PathVariable("itemId") int itemId) {
        ModelAndView modelAndView = new ModelAndView();
        Item item = itemService.findItemById(itemId);
        modelAndView.addObject("itemName", item.getName());
        modelAndView.addObject("itemDescription", item.getDescription());
        modelAndView.addObject("itemPrice", "$" + item.getPrice());
        modelAndView.setViewName("productDisplayPage");
        return modelAndView;
    }

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
