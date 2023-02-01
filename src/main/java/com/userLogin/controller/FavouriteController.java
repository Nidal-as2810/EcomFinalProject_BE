package com.userLogin.controller;

import com.userLogin.model.favourite.Favourite;
import com.userLogin.model.favourite.FavouriteResponse;
import com.userLogin.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourite")
@CrossOrigin
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping("/create")
    public void addToFavourite(@RequestBody Favourite favourite){
        favouriteService.create(favourite);
    }

    @DeleteMapping("/delete/{id}")
    public void removeFromFavourite(@PathVariable Long id){
        favouriteService.delete(id);
    }

    @GetMapping("/getAll/{username}")
    public List<FavouriteResponse> getAllFavouriteList(@PathVariable String username){
        return favouriteService.getAll(username);
    }

}
