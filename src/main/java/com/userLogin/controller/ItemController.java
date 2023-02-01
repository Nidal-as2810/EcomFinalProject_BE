package com.userLogin.controller;


import com.userLogin.model.store.Item;
import com.userLogin.service.store.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public void create(@RequestBody Item item){
        itemService.create(item);
    }

    @PutMapping("/update")
    public void update(@RequestBody Item item){
        itemService.update(item);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        itemService.delete(id);
    }

    @DeleteMapping("/deleteBySubcategory/{subId}")
    public void deleteBySubcategoryId(@PathVariable Long subId){
        itemService.deleteBySubCategoryId(subId);
    }

    @GetMapping("/public/getByName/{name}")
    public List<Item> getByName(@PathVariable String name){
        return itemService.findItemByName(name);
    }

    @GetMapping("/public/getByPriceRange")
    public List<Item> getByPriceRange(@RequestParam float minPrice, @RequestParam float maxPrice){
        return itemService.findByPriceRange(minPrice,maxPrice);
    }

    @GetMapping("/public/getBySubcategory/{subId}")
    public List<Item> getBySubcategory(@PathVariable Long subId){
        return itemService.getBySubCategoryId(subId);
    }

    @GetMapping("/public/getAll")
    public List<Item> getAll(){
        return itemService.getAll();
    }
}
