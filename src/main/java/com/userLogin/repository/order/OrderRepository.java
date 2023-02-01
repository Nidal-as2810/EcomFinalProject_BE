package com.userLogin.repository.order;



import com.userLogin.model.order.Order;

import java.util.List;

public interface OrderRepository {
    Long createOrder(Order order);
    Order getOrderByTypeAndUserId(String type,Long userId);
    void updateTempOrder(Order order);
    void deleteTempOrder(Long orderId);
    void deleteOrdersByUserId(Long userId);
    List<Order> getAllClosedOrdersByUserId(Long userId);
    void closeOrder(Long orderId);
}
