package com.github.yornellas.shoppingcart.repository;

import com.github.yornellas.shoppingcart.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
