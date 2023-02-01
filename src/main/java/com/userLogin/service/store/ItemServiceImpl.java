package com.userLogin.service.store;


import com.userLogin.model.store.Item;
import com.userLogin.repository.store.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void create(Item item) {
        itemRepository.create(item);
    }

    @Override
    public void update(Item item) {
        itemRepository.update(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public void deleteBySubCategoryId(Long subId) {
        itemRepository.deleteBySubCategoryId(subId);
    }

    @Override
    public List<Item> findItemByName(String name) {
        return itemRepository.findItemByName(name);
    }

    @Override
    public List<Item> findByPriceRange(float minPrice, float maxPrice) {
        return itemRepository.findByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Item> getBySubCategoryId(Long subId) {
        return itemRepository.getBySubCategoryId(subId);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.getAll();
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findItemById(id);
    }
}
