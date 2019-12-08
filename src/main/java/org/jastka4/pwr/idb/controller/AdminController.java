package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.repository.ItemRepository;
import org.jastka4.pwr.idb.repository.OrderRepository;
import org.jastka4.pwr.idb.repository.UserRepository;
import org.jastka4.pwr.idb.service.ItemService;
import org.jastka4.pwr.idb.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;
    @Resource
    private ItemRepository itemRepository;
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private ItemService itemService;

    @GetMapping(value = "/home")
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("usersCount", userRepository.findAll().size());
        modelAndView.addObject("itemsCount", itemRepository.findAll().size());
        modelAndView.addObject("ordersCount", orderRepository.findAll().size());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("/admin/home");
        return modelAndView;
    }

    @GetMapping(value = "/customers")
    public ModelAndView customersList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userRepository.findAll());
        modelAndView.setViewName("/admin/users");
        return modelAndView;
    }

    @GetMapping(value = "/products")
    public ModelAndView productsList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", itemService.findAll());
        modelAndView.setViewName("/admin/products");
        return modelAndView;
    }

    @GetMapping(value = "/products/add")
    public ModelAndView getAddProductPage() {
        final Item item = new Item();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("create", true);
        modelAndView.addObject("item", item);
        modelAndView.setViewName("/admin/products");
        return modelAndView;
    }

    @PostMapping(value = "/products/add")
    public @ResponseBody
    ModelAndView addProduct(final Item item, final BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (itemService.findItemByName(item.getName()) != null) {
            bindingResult.rejectValue("name", "error.item", "Przedmiot o takiej nazwie już istnieje!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/admin/products");
        } else {
            itemService.saveItem(item);
            modelAndView.addObject("create", true);
            modelAndView.addObject("successMessage", "Product has been added successfully!");
            modelAndView.addObject("item", new Item());
            modelAndView.setViewName("/admin/products");
        }
        return modelAndView;
    }

    @GetMapping(value = "/orders")
    public ModelAndView ordersList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", orderRepository.findAll());
        modelAndView.setViewName("/admin/orders");
        return modelAndView;
    }
}
