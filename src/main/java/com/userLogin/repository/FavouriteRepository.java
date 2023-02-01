package com.userLogin.repository;

import com.userLogin.model.favourite.Favourite;
import com.userLogin.model.favourite.FavouriteResponse;

import java.util.List;

public interface FavouriteRepository {
    void create(Favourite favourite);
    void delete(Long id);
    List<Favourite> getAll(String username);
    Favourite findById(Long id);
}
