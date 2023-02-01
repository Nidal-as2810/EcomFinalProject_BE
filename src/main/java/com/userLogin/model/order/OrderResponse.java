package com.userLogin.model.order;

import java.time.LocalDate;
import java.util.List;

public class OrderResponse {
    private Long id;
    private LocalDate date;
    private Long user_id;
    private Float total;
    private OrderType orderType;
    List<OrderItemResponse> items;

    public Long getId() {
        return id;
    }

    public OrderResponse(Long id, LocalDate date, Long user_id, OrderType orderType, List<OrderItemResponse> items) {
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.orderType = orderType;
        this.items = items;
        this.total=totalPerOrder(items);
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Float getTotal() {
        return total;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    private Float totalPerOrder(List<OrderItemResponse> items){
        float totalSum=0;
        for(OrderItemResponse item:items){
            totalSum+=item.getTotal();
        }
        return totalSum;
    }
}
