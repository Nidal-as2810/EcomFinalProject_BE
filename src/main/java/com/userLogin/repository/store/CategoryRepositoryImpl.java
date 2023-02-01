package com.userLogin.repository.store;

import com.userLogin.model.store.Category;
import com.userLogin.repository.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
    private static final String TABLE_NAME="category";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(String categoryName) {
            String sql = "Insert Into " + TABLE_NAME + "(category_name) Values(?)";
            jdbcTemplate.update(sql,
                    categoryName);
    }

    @Override
    public void update(Category category) {
        String sql = "Update " + TABLE_NAME + " Set category_name=? ,category_name_ar=?,category_name_he=? Where id=?";
        jdbcTemplate.update(sql,category.getName(),
                category.getNameAr(),
                category.getNameHe(),
                category.getId());
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        String sql="Select * From "+TABLE_NAME+" Where category_name='"+categoryName+"'";
        try{
            return jdbcTemplate.queryForObject(sql,new CategoryMapper());
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        String sql="Select * From "+TABLE_NAME+"";
        try{
            return jdbcTemplate.query(sql,new CategoryMapper());
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }
}
