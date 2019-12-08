package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ItemService itemService;

    @GetMapping(params = {"id"})
    public ModelAndView showProduct(@RequestParam(value = "id") int itemId) {
        ModelAndView modelAndView = new ModelAndView();
        Item item = itemService.findItemById(itemId);
        modelAndView.addObject("product", item);
        modelAndView.setViewName("productDisplayPage");
        return modelAndView;
    }
}
