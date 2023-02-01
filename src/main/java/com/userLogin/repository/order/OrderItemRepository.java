package com.userLogin.repository.order;


import com.userLogin.model.order.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    void addItem(OrderItem item);
    void update(OrderItem item);
    void delete(Long id);
    List<OrderItem> getItemByOrderId(Long orderId);
    void deleteItemsByOrderId(Long orderId);
    Integer orderItemsCount();
}
