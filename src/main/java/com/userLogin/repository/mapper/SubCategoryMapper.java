package com.userLogin.repository.mapper;


import com.userLogin.model.store.SubCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategoryMapper implements RowMapper<SubCategory> {
    @Override
    public SubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SubCategory(
                rs.getLong("id"),
                rs.getString("sub_name"),
                rs.getString("sub_name_ar"),
                rs.getString("sub_name_he"),
                rs.getLong("category_id")
        );
    }
}
