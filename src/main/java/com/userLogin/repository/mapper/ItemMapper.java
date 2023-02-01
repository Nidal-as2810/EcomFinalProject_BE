package com.userLogin.repository.mapper;



import com.userLogin.model.store.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getFloat("price"),
                rs.getInt("quantity"),
                rs.getString("unit"),
                rs.getString("image"),
                rs.getLong("subcategory_id"),
                rs.getString("is_favourite")
        );
    }
}
