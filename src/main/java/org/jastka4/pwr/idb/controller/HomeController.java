package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private ItemRepository itemRepository;

    @GetMapping(value = "/")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemRepository.findAll());
        modelAndView.setViewName("productListingPage");
        return modelAndView;
    }

    @GetMapping("/privacyPolicy")
    public ModelAndView getPrivacyPolicy() {
        return new ModelAndView("privacyPolicy");
    }
}
