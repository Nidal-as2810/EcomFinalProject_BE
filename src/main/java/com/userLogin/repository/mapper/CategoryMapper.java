package com.userLogin.repository.mapper;



import com.userLogin.model.store.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category_name"),
                rs.getString("category_name_ar"),
                rs.getString("category_name_he")
        );
    }
}
