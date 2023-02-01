package com.userLogin.repository.store;

import com.userLogin.model.store.SubCategory;
import com.userLogin.repository.mapper.SubCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubCategoryRepositoryImpl implements SubCategoryRepository{
    private static final String TABLE_NAME="subcategory";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(SubCategory subCategory) {
        String sql="Insert Into "+TABLE_NAME+"(sub_name,sub_name_ar,sub_name_he,category_id) Values(?,?,?,?)";
        jdbcTemplate.update(sql,
                subCategory.getName(),
                subCategory.getNameAr(),
                subCategory.getNameHe(),
                subCategory.getCategoryId());
    }

    @Override
    public void update(SubCategory subCategory) {
        String sql="Update "+TABLE_NAME+" Set sub_name=?,sub_name_ar=?,sub_name_he=?,category_id=? Where id=?";
        jdbcTemplate.update(sql,
                subCategory.getName(),
                subCategory.getNameAr(),
                subCategory.getNameHe(),
                subCategory.getCategoryId(),
                subCategory.getId());
    }

    @Override
    public void delete(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void deleteByCategoryId(Long categoryId) {
        String sql="Delete From "+TABLE_NAME+" Where category_id=?";
        jdbcTemplate.update(sql,categoryId);
    }

    @Override
    public List<SubCategory> getAll() {
        String sql="Select * From "+TABLE_NAME;
        try {
            return jdbcTemplate.query(sql,new SubCategoryMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<SubCategory> getByCategoryId(Long categoryId) {
        String sql="Select * From "+TABLE_NAME+" Where category_id="+categoryId;
        try {
            return jdbcTemplate.query(sql,new SubCategoryMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public SubCategory findByName(String subCategoryName) {
        String sql="Select * From "+TABLE_NAME+" Where sub_name='"+subCategoryName+"'";
        try {
            return jdbcTemplate.queryForObject(sql,new SubCategoryMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
}
