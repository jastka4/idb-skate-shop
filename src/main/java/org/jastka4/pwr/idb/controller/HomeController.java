package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productListingPage");
        return modelAndView;
    }

    @GetMapping(value = "/product")
    public ModelAndView helloProduct() {
        ModelAndView modelAndView = new ModelAndView();
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
