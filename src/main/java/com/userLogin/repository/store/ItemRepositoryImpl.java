package com.userLogin.repository.store;


import com.userLogin.model.store.Item;
import com.userLogin.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String TABLE_NAME="item";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Item item) {
        String sql="Insert Into "+TABLE_NAME+"(name,description,price,quantity,unit,image,subcategory_id) " +
                "Values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getQuantity(),
                item.getUnit(),
                item.getImage(),
                item.getSubcategoryId()
        );
    }

    @Override
    public void update(Item item) {
        String sql="Update "+TABLE_NAME+" Set name=?,description=?,price=?,quantity=?,unit=?,image=?,subcategory_id=?, is_favourite=? Where id=?";

        jdbcTemplate.update(
                sql,
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getQuantity(),
                item.getUnit(),
                item.getImage(),
                item.getSubcategoryId(),
                item.getId(),
                item.getIsFavourite()
        );
    }

    @Override
    public void delete(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void deleteBySubCategoryId(Long subId) {
        String sql="Delete From "+TABLE_NAME+" Where subcategory_id=?";
        jdbcTemplate.update(sql,subId);
    }

    @Override
    public List<Item> findItemByName(String name) {
        String sql="Select * From "+TABLE_NAME+" Where name='"+name+"'";
        try{
            return jdbcTemplate.query(sql,new ItemMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<Item> findByPriceRange(float minPrice, float maxPrice) {
        String sql="Select * From "+TABLE_NAME+" Where price Between ? And ?";
        try{
            return jdbcTemplate.query(sql,new ItemMapper(),minPrice,maxPrice);
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<Item> getBySubCategoryId(Long subId) {
        String sql="Select * From "+TABLE_NAME+" Where subcategory_id="+subId;
        try{
            return jdbcTemplate.query(sql,new ItemMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<Item> getAll() {
        String sql="Select * From "+TABLE_NAME;
        try{
            return jdbcTemplate.query(sql,new ItemMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public Item findItemById(Long id) {
        String sql="Select * From "+TABLE_NAME+" Where id="+id;
        try{
            return jdbcTemplate.queryForObject(sql,new ItemMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
}
