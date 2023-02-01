package com.userLogin.service.order;

import com.userLogin.model.CustomUser;
import com.userLogin.model.order.Order;
import com.userLogin.model.order.OrderItemResponse;
import com.userLogin.model.order.OrderResponse;
import com.userLogin.model.order.OrderType;
import com.userLogin.repository.order.OrderRepository;
import com.userLogin.service.UserService;
import com.userLogin.utils.OrderItemUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemUtilsService orderItemUtilsService;

    @Autowired
    private UserService userService;

    @Override
    public Long createOrder(Order order) {
        Order orderExist=getTempOrderByUserId(order.getUser_id());
        if(orderExist==null){

            Long id= orderRepository.createOrder(order);
            return id;
        }else
        {
            return orderExist.getId();
        }

    }

    @Override
    public Order getTempOrderByUserId(Long userId) {
        return orderRepository.getOrderByTypeAndUserId(OrderType.TEMP.toString(),userId);
    }

    @Override
    public OrderResponse getTempOrderByUsername(String username) {
        CustomUser user=userService.findUserByUsername(username);
        Order order= getTempOrderByUserId(user.getId());
        List<OrderItemResponse> items=orderItemUtilsService.getOrderItems(order.getId());
        OrderResponse orderResponse=order.toOrderResponse(items);
        return orderResponse;
    }

    @Override
    public void updateTempOrder(Order order) {
        orderRepository.updateTempOrder(order);
    }

    @Override
    public String deleteTempOrder(Order order) {
        if(order.getOrderType()==OrderType.TEMP){
            orderRepository.deleteTempOrder(order.getId());
            return "Order has been deleted.";
        }else{
            return "This order can't be deleted.";
        }
    }

    @Override
    public void deleteOrdersByUsername(String username) {
        CustomUser user=userService.findUserByUsername(username);
        List<Order> orders =orderRepository.getAllClosedOrdersByUserId(user.getId());
        for(Order order:orders){
            orderItemUtilsService.deleteItemsByOrderId(order.getId());
        }
        orderRepository.deleteOrdersByUserId(user.getId());
    }

    @Override
    public List<OrderResponse> getAllClosedOrdersByUsername(String username) {
        CustomUser user=userService.findUserByUsername(username);
        List<Order> orders=orderRepository.getAllClosedOrdersByUserId(user.getId());
        List<OrderResponse> orderResponseList=new ArrayList<>();
        for(Order order:orders){
            List<OrderItemResponse> items=orderItemUtilsService.getOrderItems(order.getId());
            if(items!=null){
                orderResponseList.add(order.toOrderResponse(items));
            }
        }
        return orderResponseList;
    }

    @Override
    public void closeOrder(Long orderId) {
        orderRepository.closeOrder(orderId);
    }


}
