package com.github.yornellas.shoppingcart.repository;

import com.github.yornellas.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
