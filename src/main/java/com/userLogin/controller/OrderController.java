package com.userLogin.controller;


import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderResponse;
import com.userLogin.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getTempOrder/{username}")
    public OrderResponse getOrderByUserName(@PathVariable String username){
        OrderResponse orderResponse=orderService.getTempOrderByUsername(username);
        System.out.println(orderResponse.toString());
        return orderResponse;
    }

    @GetMapping("/getAllOrders/{username}")
    public List<OrderResponse> getAllOrders(@PathVariable String username){
        return orderService.getAllClosedOrdersByUsername(username);
    }

    @DeleteMapping("/deleteTempOrder/{username}")
    public String deleteTempOrder(@RequestBody Order order){
        return orderService.deleteTempOrder(order);
    }

    @PutMapping("/checkout/{id}")
    public void checkout(@PathVariable Long id){
        orderService.closeOrder(id);
    }
}
