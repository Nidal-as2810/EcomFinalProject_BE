package com.userLogin.repository.order;


import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderType;
import com.userLogin.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private static final String TABLE_NAME="orderTBL";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createOrder(Order order) {
        String sql="Insert into "+TABLE_NAME+"(order_date, user_id, total, type) " +
                "Values(?,?,?,?)";

        float totalOrder=0;
        if (order.getTotal()!=null){
            totalOrder=order.getTotal();
        }

        jdbcTemplate.update(sql,
                order.getDate(),
                order.getUser_id(),
                totalOrder,
                order.getOrderType().toString());

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public Order getOrderByTypeAndUserId(String type, Long userId) {
        String sql="Select * From "+TABLE_NAME+" Where type='"+type+"' And user_id="+userId;
        try{
            return jdbcTemplate.queryForObject(sql,new OrderMapper());
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public void updateTempOrder(Order order) {
        String sql="Update "+TABLE_NAME+" Set total=?, type=? " +
                "Where id=?";
        jdbcTemplate.update(
                sql,
                order.getTotal(),
                order.getOrderType().toString(),
                order.getId()
        );
    }

    @Override
    public void deleteTempOrder(Long orderId) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,orderId);
    }

    @Override
    public void deleteOrdersByUserId(Long userId) {
        String sql="Delete From "+TABLE_NAME+" Where user_id=?";
        jdbcTemplate.update(sql,userId);
    }

    @Override
    public List<Order> getAllClosedOrdersByUserId(Long userId) {
        String sql="Select * From "+TABLE_NAME+" Where user_id="+userId;
        try{
            return jdbcTemplate.query(sql,new OrderMapper());
        }catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public void closeOrder(Long orderId) {
        String sql="Update "+TABLE_NAME+" Set type=? Where id=?";
        jdbcTemplate.update(sql, OrderType.CLOSED.toString(),orderId);
    }
}
