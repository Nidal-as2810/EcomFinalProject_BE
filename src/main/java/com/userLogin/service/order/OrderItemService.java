package com.userLogin.service.order;


import com.userLogin.model.order.OrderItem;
import com.userLogin.model.order.OrderItemRequest;
import com.userLogin.model.order.OrderItemResponse;

import java.util.List;

public interface OrderItemService {
    void addItem(OrderItemRequest item, String username);
    void update(OrderItem item, String username);
    void delete(Long itemId);
    List<OrderItemResponse> getItemByOrderId(Long orderId);
    void deleteItemsByOrderId(Long orderId);
}
