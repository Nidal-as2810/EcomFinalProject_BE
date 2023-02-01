package com.userLogin.service.store;


import com.userLogin.model.store.Item;

import java.util.List;

public interface ItemService {
    void create(Item item);
    void update(Item item);
    void delete(Long id);
    void deleteBySubCategoryId(Long subId);
    List<Item> findItemByName(String name);
    List<Item> findByPriceRange(float minPrice,float maxPrice);
    List<Item> getBySubCategoryId(Long subId);
    List<Item> getAll();
    Item findItemById(Long id);
}
