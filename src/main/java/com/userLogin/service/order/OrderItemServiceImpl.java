package com.userLogin.service.order;


import com.userLogin.model.CustomUser;
import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderItem;
import com.userLogin.model.order.OrderItemRequest;
import com.userLogin.model.order.OrderItemResponse;
import com.userLogin.model.store.Item;
import com.userLogin.repository.order.OrderItemRepository;
import com.userLogin.service.UserService;
import com.userLogin.service.store.ItemService;
import com.userLogin.utils.OrderUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Autowired
    private OrderUtilsService utilsService;


    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Override
    public void addItem(OrderItemRequest item, String username) {
        CustomUser user=userService.findUserByUsername(username);
        Long orderId=utilsService.createOrder(user.getId());
        Item currentItem=itemService.findItemById(item.getItemId());
        OrderItem orderItem=item.toOrderItem(currentItem,orderId);

        orderItemRepository.addItem(orderItem);

        updateOrder(orderId,user.getId());
    }

    @Override
    public void update(OrderItem item,String username) {
        orderItemRepository.update(item);
        CustomUser user=userService.findUserByUsername(username);
        updateOrder(item.getOrder_id(),user.getId());
    }

    @Override
    public void delete(Long itemId) {
            orderItemRepository.delete(itemId);
    }

    @Override
    public List<OrderItemResponse> getItemByOrderId(Long orderId) {
        List<OrderItem> orderItems=orderItemRepository.getItemByOrderId(orderId);
        List<OrderItemResponse> list=new ArrayList<>();
        if(orderItems !=null){
            for(OrderItem item :orderItems){
                Item item1=itemService.findItemById(item.getItem_id());
                list.add(item.toOrderItemResponse(item1));
            }
            return list;
        }else {
            return null;
        }
    }

    @Override
    public void deleteItemsByOrderId(Long orderId) {
        orderItemRepository.deleteItemsByOrderId(orderId);
    }

    private void updateOrder(Long orderId, Long userId){
        List<OrderItemResponse> items=getItemByOrderId(orderId);
        utilsService.tempOrderUpdate(userId,items);
    }
}
