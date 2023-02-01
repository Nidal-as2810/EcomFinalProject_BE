package com.userLogin.repository.mapper;

import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getLong("user_id"),
                rs.getFloat("total"),
                OrderType.valueOf(rs.getString("type"))
        );
    }
}
