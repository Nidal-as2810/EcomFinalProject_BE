package com.userLogin.controller;

import com.userLogin.model.order.OrderItem;
import com.userLogin.model.order.OrderItemRequest;
import com.userLogin.service.order.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderItem")
@CrossOrigin
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add/{username}")
    public void addItem(@RequestBody OrderItemRequest itemRequest, @PathVariable String username){
        orderItemService.addItem(itemRequest,username);
    }

    @PutMapping("/update/{username}")
    public void updateItem(@RequestBody OrderItem item, @PathVariable String username){
        orderItemService.update(item,username);
    }

    @DeleteMapping("/delete/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        orderItemService.delete(itemId);
    }


}
