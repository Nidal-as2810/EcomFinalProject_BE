package com.userLogin.model.favourite;

import com.userLogin.model.store.Item;

public class Favourite {
    private Long id;
    private Long ItemId;
    private String username;

    public Favourite(Long id, Long itemId, String username) {
        this.id = id;
        ItemId = itemId;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public FavouriteResponse toFavouriteResponse(Item item){
        return new FavouriteResponse(this.id,item,this.username);
    }
}
