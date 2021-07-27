package com.github.yornellas.shoppingcart.controller;

import com.github.yornellas.shoppingcart.model.Cart;
import com.github.yornellas.shoppingcart.model.Item;
import com.github.yornellas.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping(value="/{id}")
    public Cart addItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Cart> savedCart  = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping(value="/{id}")
    public Optional<Cart> findById(@PathVariable Long id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    public void clear(@PathVariable Long id) {
        cartRepository.deleteById(id);
    }
}
