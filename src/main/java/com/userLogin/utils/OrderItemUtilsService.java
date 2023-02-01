package com.userLogin.utils;


import com.userLogin.model.order.OrderItemResponse;
import com.userLogin.service.order.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemUtilsService {
    @Autowired
    private OrderItemService orderItemService;

    public List<OrderItemResponse> getOrderItems(Long orderId){
        return orderItemService.getItemByOrderId(orderId);
    }

    public void  deleteItemsByOrderId(Long orderId){
        orderItemService.deleteItemsByOrderId(orderId);
    }
}
