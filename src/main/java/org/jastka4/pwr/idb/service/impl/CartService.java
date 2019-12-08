package org.jastka4.pwr.idb.service.impl;

import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CartService {
    private static final BigDecimal TAX = BigDecimal.valueOf(23);
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal SHIPPING = BigDecimal.valueOf(5);

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findById(int id) {
        return cartRepository.findById(id);
    }

    public Cart saveCart(Cart cart) {
        cartRepository.save(cart);
        return cart;
    }

    public BigDecimal getTax(final Cart cart) {
        return cart.getValue().multiply(TAX).divide(ONE_HUNDRED, RoundingMode.CEILING);
    }

    public BigDecimal getTotalPrice(final Cart cart) {
        final BigDecimal tax = getTax(cart);
        final BigDecimal shipping = getShipping(cart);
        return cart.getValue().add(tax).add(shipping);
    }

    public BigDecimal getShipping(final Cart cart) {
        return SHIPPING;
    }
}
