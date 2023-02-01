package com.userLogin.service;

import com.userLogin.model.favourite.Favourite;
import com.userLogin.model.favourite.FavouriteResponse;

import java.util.List;

public interface FavouriteService {
    void create(Favourite favourite);
    void delete(Long id);
    List<FavouriteResponse> getAll(String username);
}
