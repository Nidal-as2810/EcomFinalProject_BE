package com.userLogin.utils;


import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderItemResponse;
import com.userLogin.model.order.OrderResponse;
import com.userLogin.model.order.OrderType;
import com.userLogin.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderUtilsService {
    @Autowired
    private OrderService orderService;

    public Long createOrder(Long userId){
       return orderService.createOrder(new Order(null, LocalDate.now(),userId,null, OrderType.TEMP));
    }

    public Order getOrder(String username){
        OrderResponse order=orderService.getTempOrderByUsername(username);
        return orderService.getTempOrderByUserId(order.getId());
    }

    public void tempOrderDelete(Order order){
        orderService.deleteTempOrder(order);
    }

    public void tempOrderUpdate(Long userId, List<OrderItemResponse> items){
        Order currentOrder= orderService.getTempOrderByUserId(userId);
        currentOrder.setTotal(items);
        orderService.updateTempOrder(currentOrder);
    }
}
