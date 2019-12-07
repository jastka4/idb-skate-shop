package org.jastka4.pwr.idb.service.impl;

import org.jastka4.pwr.idb.model.Cart;
import org.jastka4.pwr.idb.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
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
}
