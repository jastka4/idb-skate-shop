package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.model.User;
import org.jastka4.pwr.idb.service.impl.CartService;
import org.jastka4.pwr.idb.service.impl.ItemService;
import org.jastka4.pwr.idb.service.impl.UserService;
import org.jastka4.pwr.idb.utils.MessagesUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @Resource
    private MessagesUtil messagesUtil;

    @GetMapping
    public ModelAndView getCart() {
        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        final ModelAndView modelAndView = new ModelAndView("cart");
        return modelAndView.addObject("cart", user.getCart());
    }

    @PostMapping(params = {"id"})
    public String addToCart(@RequestParam(value = "id") int itemId, final RedirectAttributes redirectAttributes) {
        final Item item = itemService.findItemById(itemId);
        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (Objects.nonNull(user)) {
            if (item.getAmount() > 0) {
                final Cart cart = Optional.ofNullable(user.getCart()).orElse(new Cart());
                cart.setUser(user);
                user.setCart(cart);
                cart.setDate(LocalDateTime.now());
                if (Objects.nonNull(cart.getItems())) {
                    BigDecimal newValue = new BigDecimal(0);
                    for (Item i : cart.getItems()) {
                        newValue = newValue.add(i.getPrice());
                    }
                    cart.setValue(newValue.add(item.getPrice()));
                } else cart.setValue(item.getPrice());
                cart.getItems().add(item);
                item.setAmount(item.getAmount() - 1);
                cartService.saveCart(cart);
            } else {
                redirectAttributes.addFlashAttribute("msg", messagesUtil.get("pdp.product.add_to_cart.no_stock"));
                return "redirect:/product?id=" + itemId;
            }

        } else {
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("msg", messagesUtil.get("pdp.product.add_to_cart.successful"));
        return "redirect:/product?id=" + itemId;
    }
}
