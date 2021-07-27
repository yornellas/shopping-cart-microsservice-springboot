package com.github.yornellas.shoppingcart.controller;

import com.github.yornellas.shoppingcart.model.Item;
import com.github.yornellas.shoppingcart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Item> findById(@PathVariable Long id) {
        return itemRepository.findById(id);
    }

    @PostMapping
    public Item add(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping(value = "/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> obj = itemRepository.findById(id);
        return itemRepository.save(obj.orElseThrow(NoSuchElementException::new));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
