package com.userLogin.model.favourite;

import com.userLogin.model.store.Item;

public class FavouriteResponse {
    private Long id;
    private Item item;
    private String username;

    public FavouriteResponse(Long id, Item item, String username) {
        this.id = id;
        this.item = item;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
