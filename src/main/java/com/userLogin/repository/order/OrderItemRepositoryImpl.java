package com.userLogin.repository.order;



import com.userLogin.model.order.OrderItem;
import com.userLogin.repository.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{
    private static final String TABLE_NAME="orderItem";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addItem(OrderItem item) {
        String sql="Insert Into "+TABLE_NAME+"(item_id,order_id,qty,total,price) Values(?,?,?,?,?)";
        jdbcTemplate.update(sql,
                item.getItem_id(),
                item.getOrder_id(),
                item.getQty(),
                item.getTotal(),
                item.getPrice());
    }

    @Override
    public void update(OrderItem item) {
        String sql="Update "+TABLE_NAME+" Set item_id=?,order_id=?,qty=?,total=?,price=? Where id=?";
        jdbcTemplate.update(sql,
                item.getItem_id(),
                item.getOrder_id(),
                item.getQty(),
                item.getTotal(),
                item.getPrice(),
                item.getId());
    }

    @Override
    public void delete(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<OrderItem> getItemByOrderId(Long orderId) {
        String sql="Select * From "+TABLE_NAME+" Where order_id="+orderId;
        try{
            return jdbcTemplate.query(sql,new OrderItemMapper());
        }catch (EmptyResultDataAccessException exception)
        {
            return null;
        }
    }

    @Override
    public void deleteItemsByOrderId(Long orderId) {
        String sql="Delete From "+TABLE_NAME+" Where order_id=?";
        jdbcTemplate.update(sql,orderId);
    }

    @Override
    public Integer orderItemsCount() {
        String sql="SELECT COUNT(*) FROM "+TABLE_NAME;
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
