package com.userLogin.service.order;



import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderResponse;

import java.util.List;

public interface OrderService {
    Long createOrder(Order order);
    Order getTempOrderByUserId(Long userId);
    OrderResponse getTempOrderByUsername(String username);
    void updateTempOrder(Order order);
    String deleteTempOrder(Order order);
    void deleteOrdersByUsername(String username);
    List<OrderResponse> getAllClosedOrdersByUsername(String username);
    void closeOrder(Long orderId);
}
