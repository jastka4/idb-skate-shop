package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.service.impl.CartService;
import org.jastka4.pwr.idb.service.impl.ItemService;
import org.jastka4.pwr.idb.service.impl.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    private ItemService itemService;

    @Resource
    private UserService userService;

    @Resource
    private CartService cartService;

    @PostMapping(params = {"id"})
    public String addToCart(@RequestParam(value = "id") int itemId) {
        final Item item = itemService.findItemById(itemId);
        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (Objects.nonNull(user)) {
            final Cart cart = Optional.ofNullable(user.getCart()).orElse(new Cart());
            cart.setDate(LocalDateTime.now());
            cart.setValue(item.getPrice());
            cart.getItems().add(item);
            cartService.saveCart(cart);
        } else {
            return "redirect:/login";
        }

        return "redirect:/product?id=" + itemId;
    }
}
