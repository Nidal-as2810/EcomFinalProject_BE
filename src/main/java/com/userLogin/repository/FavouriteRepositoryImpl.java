package com.userLogin.repository;

import com.userLogin.model.favourite.Favourite;
import com.userLogin.repository.mapper.FavouriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FavouriteRepositoryImpl implements FavouriteRepository{
    private static final String TABLE_NAME="favourites";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Favourite favourite) {
        String sql="Insert Into "+TABLE_NAME+"(item_id,username) Values(?,?)";
        jdbcTemplate.update(sql,favourite.getItemId(),favourite.getUsername());
    }

    @Override
    public void delete(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Favourite> getAll(String username) {
        String sql="Select * From "+TABLE_NAME+" Where username=?";
        try{
            return jdbcTemplate.query(sql,new FavouriteMapper(),username);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public Favourite findById(Long id) {
        String sql="Select * From "+TABLE_NAME+" Where id=?";
        try{
            return jdbcTemplate.queryForObject(sql,new FavouriteMapper(),id);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }
}
