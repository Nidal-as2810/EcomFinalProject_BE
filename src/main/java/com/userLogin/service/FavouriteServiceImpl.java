package com.userLogin.service;

import com.userLogin.model.favourite.Favourite;
import com.userLogin.model.favourite.FavouriteResponse;
import com.userLogin.model.store.Item;
import com.userLogin.repository.FavouriteRepository;
import com.userLogin.service.store.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{
    @Autowired
    private FavouriteRepository favouriteRepository;
    @Autowired
    private ItemService itemService;

    @Override
    public void create(Favourite favourite) {
        Item current=itemService.findItemById(favourite.getItemId());
        current.setIsFavourite("ye favourite");
        itemService.update(current);
        favouriteRepository.create(favourite);
    }

    @Override
    public void delete(Long id) {
        Favourite favourite=favouriteRepository.findById(id);
        Item item=itemService.findItemById(favourite.getItemId());
        item.setIsFavourite("no");
        itemService.update(item);
        favouriteRepository.delete(id);
    }

    @Override
    public List<FavouriteResponse> getAll(String username) {
        List<Favourite> list=favouriteRepository.getAll(username);
        List<FavouriteResponse> favourites=new ArrayList<>();
        for(Favourite item :list){
            Item current=itemService.findItemById(item.getItemId());
            favourites.add(item.toFavouriteResponse(current));
        }
        return favourites;
    }
}
